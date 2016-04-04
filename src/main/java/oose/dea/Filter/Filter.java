package oose.dea.Filter;

import oose.dea.Photo.Photo;

import java.util.ArrayList;

public abstract class Filter {
    private String description;
    private ArrayList<Photo> photo;

    public Filter(String description, ArrayList<Photo> photo) {
        this.description = description;
        this.photo = photo;
    }

    public String getDescription() {
        return null;
    }

    public void setDescription(String description) {
    }

    @Override
    public String toString() {
        return "Filter{" +
                "owner='" + description + '\'' +
                '}';
    }
}
