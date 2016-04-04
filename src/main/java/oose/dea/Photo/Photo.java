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

    public Photo(String creator, String title, String url, String description, Set set, Filter filter, ArrayList<Privacy> privacy) {
        this.creator = creator;
        this.title = title;
        this.url = url;
        this.description = description;
        this.set = set;
        this.filter = filter;
        this.privacy = privacy;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
    }

    public void setFilter(int f) {
    }

    @Override
    public String toString() {
        return "Photo{" +
                "creator='" + creator + '\'' +
                ", title='" + title + '\'' +
                ", url='" + url + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
