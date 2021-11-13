package com.umanizales.lists_prog2.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class GendersByGradesDTO {
    private byte grade;
    private List<CountByGenderDTO> genders;
    private int total;
}
