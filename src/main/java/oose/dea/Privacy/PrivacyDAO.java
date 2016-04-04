package oose.dea.Privacy;

import com.google.inject.Inject;
import oose.dea.Photo.Photo;
import oose.dea.Photo.PhotoModel;
import oose.dea.Set.Set;
import oose.dea.Set.SetModel;
import oose.dea.datasource.util.DatabaseProperties;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PrivacyDAO {
    private Logger logger = Logger.getLogger(getClass().getName());

    @Inject
    private DatabaseProperties databaseProperties;

    @Inject
    private SetModel setModel;

   public ArrayList<Privacy> findAll() {
        ArrayList<Privacy> privacies = new ArrayList<>();
        tryFindAll(privacies);
        return privacies;
   }

    public ArrayList<Privacy> findByPhotoId(int photoId) {
        ArrayList<Privacy> privacies = new ArrayList<>();
        tryFindphotoId(privacies, photoId);
        return privacies;
    }

   private void tryFindAll(List<Privacy> privacies) {
        try {
            Connection connection = DriverManager.getConnection(databaseProperties.connectionString());
            PreparedStatement statement = connection.prepareStatement("SELECT * from Privacy");
            addNewFromDatabase(privacies, statement);
            statement.close();
            connection.close();
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error communicating with database " + databaseProperties.connectionString(), e);
        }
    }

    private void tryFindphotoId(List<Privacy> privacies, int photoId) {
        try {
            Connection connection = DriverManager.getConnection(databaseProperties.connectionString());
            PreparedStatement statement = connection.prepareStatement("SELECT * from Privacy WHERE photoId = ?");
            statement.setInt(1, photoId);

            addNewFromDatabase(privacies, statement);
            statement.close();
            connection.close();
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error communicating with database " + databaseProperties.connectionString(), e);
        }
    }

    private void addNewFromDatabase(List<Privacy> privacies, PreparedStatement statement) throws SQLException {
        ResultSet resultSet = statement.executeQuery();

        while (resultSet.next()) {
            addNewFromResultSet(privacies, resultSet);
        }
    }

    private void addNewFromResultSet(List<Privacy> privacies, ResultSet resultSet) throws SQLException {
        Privacy privacy = new Privacy(resultSet.getInt("photoId"), resultSet.getInt("setId'"), resultSet.getBoolean("open"));
        privacies.add(privacy);
    }
}
