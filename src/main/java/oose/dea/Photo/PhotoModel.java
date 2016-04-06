package oose.dea.Photo;

import com.google.inject.Inject;
import oose.dea.Filter.Filter;
import oose.dea.Filter.GrayFilter;
import oose.dea.Filter.VintageFilter;
import oose.dea.Privacy.Privacy;

import java.util.ArrayList;

public class PhotoModel {

    @Inject
    private PhotoSQLDAO photoSQLDAO;

    public ArrayList<Photo> getPhotos(String searchTerm) {
        return photoSQLDAO.findByTitle(searchTerm);
    }

    public ArrayList<Photo> getAllPhotos() {
        return photoSQLDAO.findAll();
    }

    public Photo getByPhoto(int id) {
        return photoSQLDAO.findById(id);
    }


    public boolean applyFilter(int photoId, String filter, ArrayList<String> filterArguments) {
        Filter filterObject = null;

        if (filter.equals("gray")) {
            filterObject = new GrayFilter();
            ((GrayFilter)filterObject).setPercentage(Integer.parseInt(filterArguments.get(0)));
        } else if (filter.equals("vintage")) {
            filterObject = new VintageFilter();
            ((VintageFilter)filterObject).setUpperLeftX(Integer.parseInt(filterArguments.get(0)));
            ((VintageFilter)filterObject).setUpperLeftY(Integer.parseInt(filterArguments.get(1)));
            ((VintageFilter)filterObject).setLowerRightX(Integer.parseInt(filterArguments.get(2)));
            ((VintageFilter)filterObject).setLowerRightY(Integer.parseInt(filterArguments.get(3)));
        }

        return photoSQLDAO.applyFilter(photoId, filterObject);
    }

    public boolean insertPhoto(String creator, String title, String url, String description) {
        return photoSQLDAO.insertPhoto(new Photo(
                0,
                creator,
                title,
                url,
                description,
                new ArrayList<Privacy>(),
                null
        ));
    }
}
