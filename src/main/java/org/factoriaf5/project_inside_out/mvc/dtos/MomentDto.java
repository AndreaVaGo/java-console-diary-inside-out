package org.factoriaf5.project_inside_out.mvc.dtos;

import java.time.LocalDate;
import org.factoriaf5.project_inside_out.mvc.models.Emotion;

public class MomentDto {

    private Integer id;
    private String title;
    private String description;
    private Emotion emotion;
    private LocalDate momentDate;
    private LocalDate creationDate;
    private LocalDate modificationDate;

    public MomentDto(Integer id, String title, String description, Emotion emotion,
            LocalDate momentDate, LocalDate creationDate, LocalDate modificationDate) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.emotion = emotion;
        this.momentDate = momentDate;
        this.creationDate = creationDate;
        this.modificationDate = modificationDate;
    }

    public Integer getId() {
        return id;
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
