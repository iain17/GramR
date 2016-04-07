package oose.dea.Photo;

import oose.dea.Filter.Filter;
import oose.dea.Filter.FilterDAO;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import static org.mockito.Mockito.*;

public class PhotoServiceTest {
    private PhotoDAO photoDAO;
    private FilterDAO filterDAO;

    @Before
    public void initialize() {
        photoDAO = Mockito.mock(PhotoDAO.class);
        filterDAO = Mockito.mock(FilterDAO.class);
    }

    @Test
    public void testFindById() throws Exception {
        Photo photo = Mockito.mock(Photo.class);
        when(photoDAO.findById(175)).thenReturn(photo);
        photoDAO.findById(175);

        verify(photoDAO, times(1)).findById(175);
    }

//    @Test
//    public void testFilter() throws Exception {
//        Photo photo = Mockito.mock(Photo.class);
//        Filter filter = Mockito.mock(Filter.class);
//
//        when(photoDAO.findById(1337)).thenReturn(photo);
//        photoDAO.applyFilter(1337, filter);
//        verify(photoDAO, times(1)).applyFilter(1337, filter);
//    }
}
