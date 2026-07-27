package org.factoriaf5.project_inside_out.mvc.controllers;

import java.time.LocalDate;
import java.util.List;

import org.factoriaf5.project_inside_out.mvc.contracts.InterfaceRepository;
import org.factoriaf5.project_inside_out.mvc.models.Emotion;
import org.factoriaf5.project_inside_out.mvc.models.Moment;

public class MomentController {
    private InterfaceRepository repository;

    public MomentController(InterfaceRepository repository) {
        this.repository = repository;
    }

    public void addMoment(Moment moment){
        repository.save(moment);
    }

    public List<Moment> listMoments(){
        return repository.findAll();
    }

    public void deleteMoment(Integer id){
        repository.delete(id);
    }

    public List<Moment> filterByEmotion(Emotion emotion){
        return repository.findByEmotion(emotion);
    }

    public List<Moment> filterByMonth(LocalDate date){
        return repository.findByMonth(date);
    }
}
