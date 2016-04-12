package oose.dea.Set;

import oose.dea.datasource.util.DatabaseProperties;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;
import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertNull;

public class SetModelTest {
    private SetModel setModel;

    @Before
    public void createClass() {
        SetSQLDAO setDAO = new SetSQLDAO();
        setDAO.setDatabaseProperties(new DatabaseProperties());
        this.setModel = new SetModel(setDAO);
    }

    @Test
    public void testSuccessInsert() throws Exception {
        assertEquals(true, setModel.insertSet("Test1", "Wim"));
    }

    @Test
    public void TestGetSets() throws Exception {
        ArrayList<Set> sets = setModel.getAllSets("Wim");
        assertNotNull(sets);
    }

    @Test
    public void TestGetSet() throws Exception {
        //The database auto increments. So there is at least id 1 after this insert.
        assertEquals(true, setModel.insertSet("Test2", "Wim"));

        Set set = setModel.getSet(1);
        assertNotNull(set);
    }

    @Test
    public void TestFailGetSet() throws Exception {
        Set set = setModel.getSet(-1);
        assertNull(set);
    }
}
