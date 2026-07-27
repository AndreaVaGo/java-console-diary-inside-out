package org.factoriaf5.project_inside_out.mvc.models;

import java.time.LocalDate;

public class Moment {

    private Integer id;
    private String title;
    private String description;
    private Emotion emotion;
    private LocalDate momentDate;
    private LocalDate creationDate;
    private LocalDate modificationDate;

    public Moment(String title, String description, Emotion emotion, LocalDate momentDate) {
        this.title = title;
        this.description = description;
        this.emotion = emotion;
        this.momentDate = momentDate;
        this.creationDate = LocalDate.now();
        this.modificationDate = LocalDate.now();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public LocalDate getModificationDate() {
        return modificationDate;
    }

}
