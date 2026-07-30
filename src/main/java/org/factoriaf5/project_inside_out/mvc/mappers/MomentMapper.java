package org.factoriaf5.project_inside_out.mvc.mappers;

import org.factoriaf5.project_inside_out.mvc.dtos.MomentDto;
import org.factoriaf5.project_inside_out.mvc.models.Moment;

public class MomentMapper {

    public MomentDto toDto(Moment moment) {
        return new MomentDto(
            moment.getId(),
            moment.getTitle(),
            moment.getDescription(),
            moment.getEmotion(),
            moment.getMomentDate(),
            moment.getCreationDate(),
            moment.getModificationDate()
        );
    }

    public Moment toModel(MomentDto dto) {
        return new Moment(dto.getTitle(), dto.getDescription(), dto.getEmotion(), dto.getMomentDate());
    }
}
