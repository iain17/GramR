package oose.dea.Privacy;

import java.util.ArrayList;

public interface PrivacyDAO {

    ArrayList<Privacy> findAll();
    ArrayList<Privacy> findByPhotoId(int photoId);
    boolean insertPhoto(Privacy privacy);

}
