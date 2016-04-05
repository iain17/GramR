package oose.dea.Filter;

import oose.dea.Photo.Photo;

import java.util.ArrayList;

public abstract class Filter {
    private String description;

    private ArrayList<Photo> photos;

    public Filter(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ArrayList<Photo> getPhotos() {
        return photos;
    }

    public void setPhotos(ArrayList<Photo> photos) {
        this.photos = photos;
    }

    @Override
    public String toString() {
        return "Filter{" +
                "description='" + description + '\'' +
                '}';
    }
}
