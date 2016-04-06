package oose.dea.Privacy;

import com.google.inject.Inject;

import java.util.ArrayList;

public class PrivacyModel {

    private PrivacyDAO privacyDAO;

    @Inject
    public PrivacyModel(PrivacyDAO privacyDAO) {
        this.privacyDAO = privacyDAO;
    }

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
