package oose.dea.Photo;

import oose.dea.Filter.Filter;

import java.util.ArrayList;

public interface PhotoDAO {
    ArrayList<Photo> findByTitle(String title);

    ArrayList<Photo> findAll();

    Photo findById(int photoId);

    boolean insertPhoto(Photo photo);

    boolean applyFilter(int photoId, Filter filterObject);
}
