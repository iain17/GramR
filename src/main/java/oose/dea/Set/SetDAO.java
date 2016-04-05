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

    public ArrayList<Set> findByOwner(String owner) {
        ArrayList<Set> sets = new ArrayList<>();
        tryFindOwner(sets, owner);
        return sets;
    }

    public ArrayList<Set> findAll() {
        ArrayList<Set> sets = new ArrayList<>();
        tryFindAll(sets);
        return sets;
    }

    public Set findById(int setid) {
        ArrayList<Set> sets = new ArrayList<>();
        tryFindId(sets, setid);
        return sets.get(0);
    }

    public void save(Set set) {
    }

    public void delete(int setId) {
    }

    private void tryFindAll(List<Set> sets) {
        try {
            Connection connection = DriverManager.getConnection(databaseProperties.connectionString());
            PreparedStatement statement = connection.prepareStatement("SELECT * from `Set`");
            addNewFromDatabase(sets, statement);
            statement.close();
            connection.close();
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error communicating with database " + databaseProperties.connectionString(), e);
        }
    }

    private void tryFindOwner(List<Set> sets, String owner) {
        try {
            Connection connection = DriverManager.getConnection(databaseProperties.connectionString());
            PreparedStatement statement = connection.prepareStatement("SELECT * from `Set` WHERE owner = ?");
            statement.setString(1, owner);

            addNewFromDatabase(sets, statement);
            statement.close();
            connection.close();
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error communicating with database " + databaseProperties.connectionString(), e);
        }
    }

    private void tryFindId(List<Set> sets, int setId) {
        try {
            Connection connection = DriverManager.getConnection(databaseProperties.connectionString());
            PreparedStatement statement = connection.prepareStatement("SELECT * from `Set` WHERE id = ?");
            statement.setInt(1, setId);

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
        Set set = new Set(
                resultSet.getString("owner"),
                resultSet.getString("name")
        );

        sets.add(set);
    }
}
