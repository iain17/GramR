package oose.dea.Photo;

import oose.dea.Filter.Filter;
import oose.dea.Set.Set;

import java.util.ArrayList;

public class Photo {

	private String creator;

	private String title;

	private String url;

	private String description;

	private Set set;

	private Filter filter;

	private ArrayList<Privacy> privacy;

	public String getCreator() {
		return null;
	}

	public String getTitle() {
		return null;
	}

	public String getUrl() {
		return null;
	}

	public String getDescription() {
		return null;
	}


    public Photo(String creator, String title, String url, String description, Set set, Filter filter, ArrayList<Privacy> privacy) {
        this.creator = creator;
        this.title = title;
        this.url = url;
        this.description = description;
        this.set = set;
        this.filter = filter;
        this.privacy = privacy;
    }

    public void setCreator(String creator) {

	}

	public void setTitle(String title) {

	}

	public void setUrl(String url) {

	}

	public void setDescription(String description) {

	}

	public void setFilter(int f) {

	}

}
