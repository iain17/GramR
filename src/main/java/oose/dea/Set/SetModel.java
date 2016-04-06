package oose.dea.Set;

import com.google.inject.Inject;

import java.util.ArrayList;

public class SetModel {

    @Inject
    private SetDAO setDAO;

    public ArrayList<Set> getAllSets(String owner) {
        return setDAO.findByOwner(owner);
    }

    public boolean insertSet(String name, String owner) {
        return setDAO.save(new Set(0, owner, name));
    }

    public ArrayList<Set> readSetsFromModel() {
        return setDAO.findAll();
    }

    public Set getSet(int setId) {
        return setDAO.findById(setId);
    }

}
