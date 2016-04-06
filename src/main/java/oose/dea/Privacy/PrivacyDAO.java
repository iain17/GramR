package oose.dea.Privacy;

import java.util.ArrayList;

/**
 * Created by iain17 on 06/04/16.
 */
public interface PrivacyDAO {

    ArrayList<Privacy> findAll();
    ArrayList<Privacy> findByPhotoId(int photoId);
    boolean insertPhoto(Privacy privacy);

}
