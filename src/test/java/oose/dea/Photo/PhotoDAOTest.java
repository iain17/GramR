package oose.dea.Photo;

import oose.dea.Filter.GrayFilter;
import oose.dea.Photo.Photo;
import oose.dea.Photo.PhotoModel;
import oose.dea.Photo.PhotoSQLDAO;
import oose.dea.datasource.util.DatabaseProperties;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class PhotoDAOTest {
    private PhotoDAO photoDAO;

    @Before
    public void createClass() {
        this.photoDAO = new PhotoSQLDAO();
        ((PhotoSQLDAO)this.photoDAO).databaseProperties = new DatabaseProperties();
    }

    @Test
    public void testSuccessInsert() throws Exception {
        assertEquals(true, photoDAO.insertPhoto(new Photo(500, "Bob", "Mooie foto", "http://google.com/", "geen", null, null)));
    }

    @Test
    public void testSuccessInsertMetFilter() throws Exception {
        GrayFilter filter = new GrayFilter();
        filter.setPercentage(75);

        assertEquals(true, photoDAO.insertPhoto(new Photo(500, "Bob", "Mooie foto", "http://google.com/", "geen", null, filter)));
    }

    @Test
    public void testFailTooLongInsert() throws Exception {
        assertEquals(false, photoDAO.insertPhoto(new Photo(800, "Bob", "This masterpiece of historical drama presents the voting rights marches in Selma, Alabama in 1965. Though the events happened fifty years ago, this film feels absolutely contemporary. Ava DuVernay directs an enlightening piece at this period in the civil rights movement, drawing out phenomenal acting performances from the talented cast. Test 123", "http://google.com/", "geen", null, null)));
    }

    @Test
    public void testFailRequiredFields() throws Exception {
        assertEquals(false, photoDAO.insertPhoto(new Photo(0, null, null, null, null, null, null)));
    }
}
