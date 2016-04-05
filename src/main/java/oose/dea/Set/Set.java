package oose.dea.Set;

import oose.dea.Photo.Photo;
import oose.dea.Privacy.Privacy;

import java.util.ArrayList;

public class Set {
    private int id;

    private String owner;

    private String name;

    private Photo photo;

    private ArrayList<Privacy> privacy;

    public Set(String owner, String name) {
        this.id = 5;
        this.owner = owner;
        this.name = name;
    }

    public void addTrack(Photo photo) {
    }

    public void changeName(String name) {
    }

    public int getId() {
        return id;
    }

    public String getOwner() {
        return owner;
    }

    public String getName() {
        return name;
    }

    public Photo getPhoto() {
        return photo;
    }

    public ArrayList<Privacy> getPrivacy() {
        return privacy;
    }

    @Override
    public String toString() {
        return "Set{" +
                "owner='" + owner + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
