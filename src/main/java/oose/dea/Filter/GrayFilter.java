package oose.dea.Filter;

import oose.dea.Photo.Photo;

import java.util.ArrayList;

public class GrayFilter extends Filter {

	private int percentage;

    public GrayFilter(String description, ArrayList<Photo> photo) {
        super(description, photo);
    }

    public int getPercentage() {
		return 0;
	}

	public void setPercentage(int percentage) {

	}

}
