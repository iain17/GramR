package oose.dea.Photo;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertSame;
import static org.mockito.Mockito.*;

public class PhotoDAOTestMock {
    private PhotoDAO photoDAO;

    @Before
    public void initialize() {
        photoDAO = Mockito.mock(PhotoDAO.class);
    }

    @Test
    public void testFindById() throws Exception {
        Photo photo = Mockito.mock(Photo.class);
        when(photoDAO.findById(1337)).thenReturn(photo);

        PhotoModel photoModel = new PhotoModel(photoDAO);

        Photo result = photoModel.getByPhoto(1337);

        verify(photoDAO, times(1)).findById(1337);
        assertEquals(result, photo);
    }
}
