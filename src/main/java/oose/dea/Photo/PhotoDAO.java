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

    public List findByTitle() {
        return null;
    }

    public ArrayList<Photo> findAll() {
        ArrayList<Photo> photos = new ArrayList<>();
        tryFindAll(photos);
        return photos;
    }

    public void findById(int photoId) {
    }

    public void savePhoto(int p) {

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
                resultSet.getString("creator"),
                resultSet.getString("title"),
                resultSet.getString("url"),
                resultSet.getString("description")
        );
        //Then get all the privacies of that photo
        ArrayList<Privacy> privacies = privacyModel.getAllPrivaciesByPhotoId(resultSet.getInt("id"));

        //Set photo for privacy.
        for(Privacy privacy : privacies) {
            privacy.setPhoto(photo);
        }

        //Set privacy for photo.
        photo.setPrivacies(privacies);
        //photo.setFilter(new Filter());


        photos.add(photo);
    }
}
