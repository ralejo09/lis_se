package com.umanizales.lists_prog2.controller.dto;

import com.umanizales.lists_prog2.model.Gender1;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class GradesByGenderDTO {
    private Gender1 gender;
    private RhByGradesDTO[] rhByGradesDTOS;
    //private List<RhByGradesDTO> rhByGradesDTOS;
}
