package org.factoriaf5.project_inside_out.dtos;

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

}
