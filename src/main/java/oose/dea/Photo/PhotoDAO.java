package oose.dea.Photo;

import com.google.inject.Inject;
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

    private PhotoModel photoModel;

	public List list() {
		return null;
	}

	public List findByTitle() {
		return null;
	}

	public ArrayList<Photo> findAll() {

        logger.log(Level.SEVERE, "findAll");

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
            addNewItemsFromDatabase(photos, statement);
            statement.close();
            connection.close();
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error communicating with database " + databaseProperties.connectionString(), e);
        }
    }

    private void addNewItemsFromDatabase(List<Photo> photos, PreparedStatement statement) throws SQLException {
        ResultSet resultSet = statement.executeQuery();

        while (resultSet.next())
        {
            addNewItemFromResultSet(photos, resultSet);
        }
    }

    private void addNewItemFromResultSet(List<Photo> photos, ResultSet resultSet) throws SQLException {
        //logger.log(Level.SEVERE, resultSet.getString("filter"));

        Photo photo = new Photo(
                resultSet.getString("creator"),
                resultSet.getString("title"),
                resultSet.getString("url"),
                resultSet.getString("description"),
                null,//Set
                null,//Filter
                null//Privacy
        );

        photos.add(photo);
    }

}
