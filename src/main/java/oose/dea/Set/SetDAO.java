package oose.dea.Set;

import com.google.inject.Inject;
import oose.dea.datasource.util.DatabaseProperties;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SetDAO {
    private Logger logger = Logger.getLogger(getClass().getName());

    @Inject
    private DatabaseProperties databaseProperties;

    public List list() {
        return null;
    }

    public List findByOwner() {
        return null;
    }

    public void save(Set set) {
    }

    public void delete(int setId) {
    }


    public ArrayList<Set> findAll() {
        ArrayList<Set> sets = new ArrayList<>();
        tryFindAll(sets);
        return sets;
    }

    public void findById(int photoId) {

    }

    private void tryFindAll(List<Set> sets) {
        try {
            Connection connection = DriverManager.getConnection(databaseProperties.connectionString());
            PreparedStatement statement = connection.prepareStatement("SELECT * from Set");
            addNewFromDatabase(sets, statement);
            statement.close();
            connection.close();
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error communicating with database " + databaseProperties.connectionString(), e);
        }
    }

    private void addNewFromDatabase(List<Set> sets, PreparedStatement statement) throws SQLException {
        ResultSet resultSet = statement.executeQuery();

        while (resultSet.next()) {
            addNewFromResultSet(sets, resultSet);
        }
    }

    private void addNewFromResultSet(List<Set> sets, ResultSet resultSet) throws SQLException {
        //logger.log(Level.SEVERE, resultSet.getString("filter"));

        Set set = new Set(
                resultSet.getString("owner"),
                resultSet.getString("name")
        );

        sets.add(set);
    }
}
