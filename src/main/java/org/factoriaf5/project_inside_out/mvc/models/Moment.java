package org.factoriaf5.project_inside_out.mvc.models;

import java.time.LocalDate;

public class Moment {

    private String title;
    private String description;
    private Emotion emotion;
    private LocalDate momentDate;

    public Moment(String title, String description, Emotion emotion, LocalDate momentDate) {
        this.title = title;
        this.description = description;
        this.emotion = emotion;
        this.momentDate = momentDate;
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

    public LocalDate getMomentDate() {
        return momentDate;
    }

}
