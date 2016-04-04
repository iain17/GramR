package oose.dea.Photo;

import com.google.inject.Inject;
import oose.dea.Filter.Filter;
import oose.dea.Privacy.Privacy;
import oose.dea.Privacy.PrivacyModel;
import oose.dea.datasource.util.DatabaseProperties;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PhotoDAO {
    private Logger logger = Logger.getLogger(getClass().getName());

    @Inject
    private DatabaseProperties databaseProperties;

    @Inject
    private PrivacyModel privacyModel;

    public List list() {
        return null;
    }

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

    public void findById(int photoId) {
    }

    public boolean insertPhoto(Photo photo) {
        return tryInsert(photo);
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

    private void tryFindAll(List<Photo> photos) {
        try {
            Connection connection = DriverManager.getConnection(databaseProperties.connectionString());
            PreparedStatement statement = connection.prepareStatement("SELECT * from Photo");
            addNewFromDatabase(photos, statement);
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
            System.out.println(statement.toString());

            addNewFromDatabase(photos, statement);
            statement.close();
            connection.close();
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error communicating with database " + databaseProperties.connectionString(), e);
        }
    }

    private void addNewFromDatabase(List<Photo> photos, PreparedStatement statement) throws SQLException {
        ResultSet resultSet = statement.executeQuery();

        while (resultSet.next()) {
            addNewFromResultSet(photos, resultSet);
        }
    }

    private void addNewFromResultSet(List<Photo> photos, ResultSet resultSet) throws SQLException {
        //logger.log(Level.SEVERE, resultSet.getString("filter"));

        //First create the photo object.
        Photo photo = new Photo(
                resultSet.getInt("id"),
                resultSet.getString("creator"),
                resultSet.getString("title"),
                resultSet.getString("url"),
                resultSet.getString("description"),
                privacyModel.getAllPrivaciesByPhotoId(resultSet.getInt("id")),
                null//filter
        );
        //

        photos.add(photo);
    }
}
