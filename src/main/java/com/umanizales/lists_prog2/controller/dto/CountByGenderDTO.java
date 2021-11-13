package com.umanizales.lists_prog2.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CountByGenderDTO {
    private String gender;
    private int count;
}
