package oose.dea.Photo;

import java.util.ArrayList;

/**
 * Created by iain17 on 06/04/16.
 */
public interface PhotoDAO {
    ArrayList<Photo> findByTitle(String title);
    ArrayList<Photo> findAll();
    Photo findById(int photoId);
    boolean insertPhoto(Photo photo);
}
