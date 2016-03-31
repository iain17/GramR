package oose.dea.datasource;

import com.google.inject.Inject;
import oose.dea.datasource.util.DatabaseProperties;
import oose.dea.domain.Item;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SQLItemDao implements ItemDao {
    private Logger logger = Logger.getLogger(getClass().getName());

    @Inject
    private DatabaseProperties databaseProperties;

    @Override
    public List<Item> list() {
        List<Item> items = new ArrayList<>();
        tryFindAll(items);
        return items;
    }

    private void tryFindAll(List<Item> items) {
        try {
            Connection connection = DriverManager.getConnection(databaseProperties.connectionString());
            PreparedStatement statement = connection.prepareStatement("SELECT * from items");
            addNewItemsFromDatabase(items, statement);
            statement.close();
            connection.close();
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error communicating with database " + databaseProperties.connectionString(), e);
        }
    }

    private void addNewItemsFromDatabase(List<Item> items, PreparedStatement statement) throws SQLException {
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next())
        {
            addNewItemFromResultSet(items, resultSet);
        }
    }

    private void addNewItemFromResultSet(List<Item> items, ResultSet resultSet) throws SQLException {
        Item item = new Item(
                resultSet.getString("sku"), resultSet.getString("category"), resultSet.getString("title")
        );
        items.add(item);
    }
}
