package oose.dea.Photo;

import oose.dea.Filter.Filter;
import oose.dea.Privacy.Privacy;

import java.util.ArrayList;

public class Photo {

    private int id;

    private String creator;

    private String title;

    private String url;

    private String description;

    private Filter filter;

    private ArrayList<Privacy> privacies;

    public Photo(int id, String creator, String title, String url, String description, ArrayList<Privacy> privacies, Filter filter) {
        this.id = id;
        this.creator = creator;
        this.title = title;
        this.url = url;
        this.description = description;
        setPrivacies(privacies);
        setFilter(filter);
    }

    public void setPrivacies(ArrayList<Privacy> privacies) {
        if(privacies == null)
            return;
        this.privacies = privacies;

        //Set photo for privacy.
        for (Privacy privacy : privacies) {
            privacy.setPhoto(this);
        }
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public int getId() {
        return id;
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
        this.url = url;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ArrayList<Privacy> getPrivacies() {
        return privacies;
    }

    public void setFilter(Filter filter) {
        this.filter = filter;
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
