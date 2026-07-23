package org.factoriaf5.project_inside_out.mvc.models;

public class Moment {

    private String title;
    private String description;
    private Emotion emotion;

    public Moment(String title, String description, Emotion emotion) {
        this.title = title;
        this.description = description;
        this.emotion = emotion;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public Emotion getEmotion() {
        return emotion;
    }

}
