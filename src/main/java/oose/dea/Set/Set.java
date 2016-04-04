package oose.dea.Set;

import oose.dea.Photo.Photo;
import oose.dea.Photo.Privacy;

import java.util.ArrayList;

public class Set {
    private String owner;

    private String name;

    private Photo photo;

    private ArrayList<Privacy> privacy;

    public Set(String owner, String name) {
        this.owner = owner;
        this.name = name;
    }

    public void addTrack(Photo photo) {
    }

    public void changeName(String name) {
    }

    @Override
    public String toString() {
        return "Set{" +
                "owner='" + owner + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
