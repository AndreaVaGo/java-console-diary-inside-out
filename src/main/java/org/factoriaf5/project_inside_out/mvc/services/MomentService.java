package org.factoriaf5.project_inside_out.mvc.services;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import org.factoriaf5.project_inside_out.mvc.contracts.InterfaceRepository;
import org.factoriaf5.project_inside_out.mvc.dtos.MomentDto;
import org.factoriaf5.project_inside_out.mvc.mappers.MomentMapper;
import org.factoriaf5.project_inside_out.mvc.models.Emotion;
import org.factoriaf5.project_inside_out.mvc.models.Moment;

public class MomentService {

    private InterfaceRepository repository;
    private MomentMapper mapper;

    public MomentService(InterfaceRepository repository, MomentMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public void addMoment(MomentDto momentDto) {
        Moment moment = mapper.toModel(momentDto);
        repository.save(moment);
    }

    public List<MomentDto> listMoments() {
        return repository.findAll().stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

    public void deleteMoment(Integer id) {
        repository.delete(id);
    }

    public List<MomentDto> filterByEmotion(Emotion emotion) {
        return repository.findByEmotion(emotion).stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

    public List<MomentDto> filterByMonth(LocalDate date) {
        return repository.findByMonth(date).stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }
}
