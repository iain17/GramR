package oose.dea.Photo;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;

@Path("/photos")
public class RestPhotoService implements PhotoService {
    private PhotoSQLDAO photoSQLDAO;

    @Inject
    public RestPhotoService(PhotoSQLDAO photoSQLDAO) {
        this.photoSQLDAO = photoSQLDAO;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Photo> getAllPhotos() {
        return photoSQLDAO.findAll();
    }

//	@GET
//	@Path("/{sku}")
//	@Produces(MediaType.APPLICATION_JSON)
//	public void applyFilter(int photoId, int filter, int filterArguments) {
//	}
}
