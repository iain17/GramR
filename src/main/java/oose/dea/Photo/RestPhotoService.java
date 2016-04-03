package oose.dea.Photo;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;

@Path("/photos")
public class RestPhotoService implements PhotoService {
	private PhotoDAO photoDAO;

    @Inject
    public RestPhotoService(PhotoDAO photoDAO) {
        this.photoDAO = photoDAO;
    }

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<Photo> getAllPhotos() {
		return photoDAO.findAll();
	}

//	public void applyFilter(int photoId, int filter, int filterArguments) {
//	}
}
