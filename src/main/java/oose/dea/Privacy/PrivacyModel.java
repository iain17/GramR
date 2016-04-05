package oose.dea.Privacy;

import com.google.inject.Inject;

import java.util.ArrayList;

public class PrivacyModel {

    @Inject
    private PrivacyDAO privacyDAO;

    public ArrayList<Privacy> getAllPrivaciesByPhotoId(int photoId) {
        return privacyDAO.findByPhotoId(photoId);
    }

    public boolean createPrivacy(int photoId, int setId, boolean open) {
        return privacyDAO.insertPhoto(new Privacy(
            photoId,
            setId,
            open
        ));
    }

}
