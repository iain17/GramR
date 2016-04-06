package oose.dea.Privacy;

import oose.dea.Photo.Photo;
import oose.dea.Set.Set;

public class Privacy {

    private boolean open;

    private Set set;

    private Photo photo;
    private int photoId;
    private int setId;

    public Privacy(int photoId, int setId, boolean open) {
        this.open = open;
        this.photoId = photoId;
        this.setId = setId;
    }

    public void toggle() {
        open = !open;
    }

    public boolean isOpen() {
        return open;
    }

    public Set getSet() {
        return set;
    }

    public void setSet(Set set) {
        this.set = set;
    }

    public Photo getPhoto() {
        return photo;
    }

    public void setPhoto(Photo photo) {
        this.photo = photo;
    }

    public int getPhotoId() {
        return photoId;
    }

    public int getSetId() {
        return setId;
    }

}