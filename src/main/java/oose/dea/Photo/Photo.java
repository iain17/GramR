package oose.dea.Photo;

import oose.dea.Filter.Filter;
import oose.dea.Privacy.Privacy;
import oose.dea.Set.Set;

import java.util.ArrayList;

public class Photo {
    private String photoId;

    private String creator;

    private String title;

    private String url;

    private String description;

    private Filter filter;

    private ArrayList<Privacy> privacies;

    public Photo(int photoId, String creator, String title, String url, String description, ArrayList<Privacy> privacies, Filter filter) {
        this.creator = creator;
        this.title = title;
        this.url = url;
        this.description = description;
        setPrivacies(privacies);
        setFilter(filter);
    }

    public void setPrivacies(ArrayList<Privacy> privacies) {
        this.privacies = privacies;

        //Set photo for privacy.
        for(Privacy privacy : privacies) {
            privacy.setPhoto(this);
        }
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
