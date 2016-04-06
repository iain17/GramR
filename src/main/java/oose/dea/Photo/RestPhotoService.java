package oose.dea.Photo;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;

@Path("/photos")
public class RestPhotoService implements PhotoService {
    private PhotoModel photoModel;

    @Inject
    public RestPhotoService(PhotoModel photoModel) {
        this.photoModel = photoModel;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Photo> getAllPhotos() {
        return photoModel.getAllPhotos();
    }

//    @Path("/{sku}")
//    @Produces(MediaType.APPLICATION_JSON)
//    public boolean applyFilter(int photoId, String filter, ArrayList<String> filterArguments) {
//        return photoModel.
//    }

    @GET
    @Path("/photo/{photoId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Photo getPhoto(@PathParam("photoId") final int photoId) {
        return photoModel.getByPhoto(photoId);
    }
}
