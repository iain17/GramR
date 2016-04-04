package oose.dea.Set;

import com.google.inject.Inject;
import oose.dea.Photo.PhotoDAO;

import java.util.ArrayList;

public class SetModel {

    @Inject
    private SetDAO setDAO;

    public ArrayList<Set> getAllSets(String owner) {
        return setDAO.findByOwner(owner);
    }

    public ArrayList<Set> readSetsFromModel() {
        return setDAO.findAll();
    }

    public Set getSet(int setId) {
        return setDAO.findById(setId);
    }

    public void putSet(Set set) {

    }

}
