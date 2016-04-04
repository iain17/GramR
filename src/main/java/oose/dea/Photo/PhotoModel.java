package oose.dea.Photo;

import com.google.inject.Inject;
import oose.dea.Privacy.Privacy;

import java.util.ArrayList;

public class PhotoModel {

    @Inject
    private PhotoDAO photoDAO;

    public void getPhotos(String searchTerm) {

    }

    public ArrayList<Photo> getAllPhotos() {
        return photoDAO.findAll();
    }

    public void readPhotosFromModel() {

    }

    public void applyFilter(int photoId, int filter, int filterArguments) {

    }

    public boolean insertPhoto(String creator, String title, String url, String description) {
        return photoDAO.insertPhoto(new Photo(
                0,
                creator,
                title,
                url,
                description,
                new ArrayList<Privacy>(),
                null
        ));
    }

}
