package oose.dea.Set;

import oose.dea.Photo.PhotoModel;

import java.util.ArrayList;

public interface SetService {

    PhotoModel photoModel = null;

    SetModel setModel = null;

    ArrayList<Set> getAllSets(int owner);
}
