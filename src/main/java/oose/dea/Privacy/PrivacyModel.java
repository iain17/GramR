package oose.dea.Privacy;

import com.google.inject.Inject;

import java.util.ArrayList;

/**
 * Created by iain17 on 04/04/16.
 */
public class PrivacyModel {

    @Inject
    private PrivacyDAO privacyDAO;

    public ArrayList<Privacy> getAllPrivaciesByPhotoId(int photoId) {
        return privacyDAO.findByPhotoId(photoId);
    }

}
