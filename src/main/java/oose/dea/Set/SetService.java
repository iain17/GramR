package oose.dea.Set;

import oose.dea.Photo.PhotoModel;

import java.util.ArrayList;

public interface SetService {

    SetModel setModel = null;

    public ArrayList<Set> getAllSets(String owner);
}
