package oose.dea.Photo;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;

@Path("/photos")
public class RestPhotoService {
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

    @GET
    @Path("/photo/{photoId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Photo getPhoto(@PathParam("photoId") final int photoId) {
        return photoModel.getByPhoto(photoId);
    }

    @POST
    @Path("/photo/{photoId}/applyFilter")
    @Consumes( MediaType.APPLICATION_FORM_URLENCODED )
    public boolean applyFilter(@PathParam("photoId") final int photoId, @FormParam("filter") final String filter, @FormParam("filterArguments") List<String> filterArguments) {
        return photoModel.applyFilter(photoId, filter, (ArrayList<String>)filterArguments);
    }

}
