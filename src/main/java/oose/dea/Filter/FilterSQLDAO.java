package oose.dea.Filter;

import com.google.inject.Inject;
import oose.dea.datasource.util.DatabaseProperties;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FilterSQLDAO implements FilterDAO {
    private Logger logger = Logger.getLogger(getClass().getName());

    @Inject
    private DatabaseProperties databaseProperties;

    public ArrayList<Filter> findAll() {
        ArrayList<Filter> filters = new ArrayList<>();
        tryFindAll(filters);
        return filters;
    }

    private void tryFindAll(List<Filter> filters) {
        try {
            Connection connection = DriverManager.getConnection(databaseProperties.connectionString());
            PreparedStatement statement = connection.prepareStatement("SELECT * from Filter");
            addNewFromDatabase(filters, statement);
            statement.close();
            connection.close();
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error communicating with database " + databaseProperties.connectionString(), e);
        }
    }

    private void addNewFromDatabase(List<Filter> filters, PreparedStatement statement) throws SQLException {
        ResultSet resultSet = statement.executeQuery();

        while (resultSet.next()) {
            addNewFromResultSet(filters, resultSet);
        }
    }

    private void addNewFromResultSet(List<Filter> filters, ResultSet resultSet) throws SQLException {
        String description = resultSet.getString("description");
        Filter filter = null;

        switch (description) {
            case "gray":
                filter = new GrayFilter();
                break;
            case "vintage":
                filter = new VintageFilter();
                break;
        }

        if (filter != null) {
            filters.add(filter);
        }
    }
}
