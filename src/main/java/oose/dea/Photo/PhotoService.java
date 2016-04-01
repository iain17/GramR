package oose.dea.Photo;

import javax.inject.Inject;
import javax.ws.rs.Path;
import java.util.ArrayList;

@Path("/items")
public class PhotoService {
	private PhotoDAO photoDAO;

    @Inject
    public PhotoService(PhotoDAO photoDAO) {
        this.photoDAO = photoDAO;
    }

	public ArrayList<Photo> getAllPhotos() {
		return photoDAO.findAll();
	}

	public void applyFilter(int photoId, int filter, int filterArguments) {
	}
}
