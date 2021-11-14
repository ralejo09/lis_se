package com.umanizales.lists_prog2.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RhByGradesDTO {
    private byte grade;
    private String rh;
    private int count;
}
