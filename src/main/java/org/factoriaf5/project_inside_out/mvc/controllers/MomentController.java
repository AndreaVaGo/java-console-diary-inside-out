package org.factoriaf5.project_inside_out.mvc.controllers;

import java.time.LocalDate;
import java.util.List;
import org.factoriaf5.project_inside_out.mvc.dtos.MomentDto;
import org.factoriaf5.project_inside_out.mvc.models.Emotion;
import org.factoriaf5.project_inside_out.mvc.services.MomentService;

public class MomentController {
    private MomentService service;

    public MomentController(MomentService service) {
        this.service = service;
    }

    public void addMoment(MomentDto moment){
        service.addMoment(moment);
    }

    public List<MomentDto> listMoments(){
        return service.listMoments();
    }

    public void deleteMoment(Integer id){
        service.deleteMoment(id);
    }

    public List<MomentDto> filterByEmotion(Emotion emotion){
        return service.filterByEmotion(emotion);
    }

    public List<MomentDto> filterByMonth(LocalDate date){
        return service.filterByMonth(date);
    }
}
