package oose.dea.Filter;

import oose.dea.Photo.Photo;

import java.util.ArrayList;

public class VintageFilter extends Filter {

    private int upperLeftX;

    private int upperLeftY;

    private int lowerRightX;

    private int lowerRightY;

    public VintageFilter(String description, ArrayList<Photo> photo) {
        super(description, photo);
    }

    public int getUpperLeftX() {
        return 0;
    }

    public void setUpperLeftX(int upperLeftX) {

    }

    public int getUpperLeftY() {
        return 0;
    }

    public void setUpperLeftY(int upperLeftY) {

    }

    public int getLowerRightX() {
        return 0;
    }

    public void setLowerRightX(int lowerRightX) {

    }

    public int getLowerRightY() {
        return 0;
    }

    public void setLowerRightY(int lowerRightY) {

    }

}
