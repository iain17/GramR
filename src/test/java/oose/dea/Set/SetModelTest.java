package oose.dea.Set;

import oose.dea.Filter.GrayFilter;
import oose.dea.Photo.Photo;
import oose.dea.Photo.PhotoSQLDAO;
import oose.dea.datasource.util.DatabaseProperties;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class SetModelTest {
    private PhotoSQLDAO photoSQLDAO;

    @Before
    public void createClass() {
        //DatabaseProperties toevoegen, kunnen we niet injecteren.
        this.photoSQLDAO = new PhotoSQLDAO();
        this.photoSQLDAO.databaseProperties = new DatabaseProperties();
    }

    @Test
    public void testSuccessInsert() throws Exception {
        assertEquals(true, photoSQLDAO.insertPhoto(new Photo(500, "Robin", "Mooie foto", "http://google.com/", "geen", null, null)));
    }

    @Test
    public void testSuccessInsertMetFilter() throws Exception {
        GrayFilter filter = new GrayFilter();
        filter.setPercentage(75);

        assertEquals(true, photoSQLDAO.insertPhoto(new Photo(500, "Robin", "Mooie foto", "http://google.com/", "geen", null, filter)));
    }

    @Test
    public void testFailDuplicateInsert() throws Exception {
        photoSQLDAO.insertPhoto(new Photo(800, "Robin", "Mooie foto", "http://google.com/", "geen", null, null));
        assertEquals(false, photoSQLDAO.insertPhoto(new Photo(800, "Robin", "Mooie foto", "http://google.com/", "geen", null, null)));
    }
    //deze test faalt nog, omdat er niks gebeurt met de eerste ID-parameter

    @Test
    public void testFailRequiredFields() throws Exception {
        assertEquals(false, photoSQLDAO.insertPhoto(new Photo(0, null, null, null, null, null, null)));
    }
    //deze test geeft een error... zoals verwacht
}
