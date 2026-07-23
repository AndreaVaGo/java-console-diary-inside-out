package org.factoriaf5.project_inside_out.mvc.models;

public class Moment {

    private String title;
    private String description;

    public Moment(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

}
