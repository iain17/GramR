package oose.dea.Photo;

import com.google.inject.Inject;
import oose.dea.Filter.Filter;
import oose.dea.Filter.GrayFilter;
import oose.dea.Filter.VintageFilter;
import oose.dea.Privacy.Privacy;
import oose.dea.Privacy.PrivacyDAO;
import oose.dea.datasource.util.DatabaseProperties;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PhotoSQLDAO implements PhotoDAO {
    @Inject
    public DatabaseProperties databaseProperties;
    private Logger logger = Logger.getLogger(getClass().getName());
    @Inject
    private PrivacyDAO privacyDAO;

    public ArrayList<Photo> findByTitle(String title) {
        ArrayList<Photo> photos = new ArrayList<>();
        tryFindByTitle(photos, title);
        return photos;
    }

    public ArrayList<Photo> findAll() {
        ArrayList<Photo> photos = new ArrayList<>();
        tryFindAll(photos);
        return photos;
    }

    public Photo findById(int photoId) {
        ArrayList<Photo> photos = new ArrayList<>();
        tryFindById(photos, photoId);
        if (photos.size() != 1) {
            return null;
        }
        return photos.get(0);
    }

    public boolean insertPhoto(Photo photo) {
        return tryInsert(photo);
    }

    public boolean applyFilter(int photoId, Filter filterObject) {
        try {
            Connection connection = DriverManager.getConnection(databaseProperties.connectionString());
            PreparedStatement statement = null;

            if (filterObject instanceof GrayFilter) {

                statement = connection.prepareStatement("UPDATE Photo " +
                        "SET filter = 'gray'," +
                        "filterGrayPercentage = ? " +
                        "WHERE id = ?");

                statement.setInt(1, ((GrayFilter) filterObject).getPercentage());
                statement.setInt(2, photoId);

            } else if (filterObject instanceof VintageFilter) {

                statement = connection.prepareStatement("UPDATE Photo SET" +
                        "filter = 'vintage', " +
                        "filterVintageUpperLeftX = ?, " +
                        "filterVintageUpperLeftY = ?, " +
                        "filterVintageLowerRightX = ?, " +
                        "filterVintageLowerRightY = ? " +
                        "WHERE id = ?");

                statement.setInt(1, ((VintageFilter) filterObject).getUpperLeftX());
                statement.setInt(2, ((VintageFilter) filterObject).getUpperLeftY());
                statement.setInt(3, ((VintageFilter) filterObject).getLowerRightX());
                statement.setInt(4, ((VintageFilter) filterObject).getLowerRightY());
                statement.setInt(5, photoId);

            }

            statement.execute();

            statement.close();
            connection.close();
            return true;
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error communicating with database " + databaseProperties.connectionString(), e);
        }
        return false;
    }

    private boolean tryInsert(Photo photo) {
        try {
            Connection connection = DriverManager.getConnection(databaseProperties.connectionString());
            PreparedStatement statement = connection.prepareStatement("INSERT INTO Photo(creator, title, url, description)" +
                    "VALUES(?, ?, ?, ?)");
            statement.setString(1, photo.getCreator());
            statement.setString(2, photo.getTitle());
            statement.setString(3, photo.getUrl());
            statement.setString(4, photo.getDescription());
            statement.execute();

            statement.close();
            connection.close();
            return true;
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error communicating with database " + databaseProperties.connectionString(), e);
        }
        return false;
    }

    private void tryFindById(List<Photo> photos, int photoId) {
        try {
            Connection connection = DriverManager.getConnection(databaseProperties.connectionString());
            PreparedStatement statement = connection.prepareStatement("SELECT * from Photo WHERE id = ?");
            statement.setInt(1, photoId);

            addNewFromDatabase(photos, statement, false);
            statement.close();
            connection.close();
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error communicating with database " + databaseProperties.connectionString(), e);
        }
    }

    private void tryFindAll(List<Photo> photos) {
        try {
            Connection connection = DriverManager.getConnection(databaseProperties.connectionString());
            PreparedStatement statement = connection.prepareStatement("SELECT * from Photo");
            addNewFromDatabase(photos, statement, false);
            statement.close();
            connection.close();
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error communicating with database " + databaseProperties.connectionString(), e);
        }
    }

    private void tryFindByTitle(List<Photo> photos, String title) {
        try {
            Connection connection = DriverManager.getConnection(databaseProperties.connectionString());
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM Photo WHERE title LIKE ?");
            statement.setString(1, "%" + title + "%");
            addNewFromDatabase(photos, statement, true);
            statement.close();
            connection.close();
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error communicating with database " + databaseProperties.connectionString(), e);
        }
    }

    private void addNewFromDatabase(List<Photo> photos, PreparedStatement statement, boolean getPrivacy) throws SQLException {
        ResultSet resultSet = statement.executeQuery();

        while (resultSet.next()) {
            addNewFromResultSet(photos, resultSet, getPrivacy);
        }
    }

    private void addNewFromResultSet(List<Photo> photos, ResultSet resultSet, boolean getPrivacy) throws SQLException {
        //logger.log(Level.SEVERE, resultSet.getString("filter"));
        String sFilter = resultSet.getString("filter");
        Filter filter = null;

        ArrayList<Privacy> privacies = new ArrayList<Privacy>();

        if (getPrivacy) {
            privacies = privacyDAO.findByPhotoId(resultSet.getInt("id"));
        }

        if (sFilter != null) {
            switch (sFilter) {
                case "gray":
                    filter = new GrayFilter();
                    ((GrayFilter) filter).setPercentage(Integer.parseInt(resultSet.getString("filterGrayPercentage")));
                    break;
                case "vintage":
                    filter = new VintageFilter();
                    ((VintageFilter) filter).setLowerRightX(Integer.parseInt(resultSet.getString("filterVintageUpperRightX")));
                    ((VintageFilter) filter).setLowerRightY(Integer.parseInt(resultSet.getString("filterVintageUpperRightY")));
                    ((VintageFilter) filter).setUpperLeftX(Integer.parseInt(resultSet.getString("filterVintageUpperLeftX")));
                    ((VintageFilter) filter).setUpperLeftY(Integer.parseInt(resultSet.getString("filterVintageUpperLeftY")));
                    break;
            }
        }

        //First create the photo object.
        Photo photo = new Photo(
                resultSet.getInt("id"),
                resultSet.getString("creator"),
                resultSet.getString("title"),
                resultSet.getString("url"),
                resultSet.getString("description"),
                privacies,
                filter
        );

        photos.add(photo);
    }
}
