package com.umanizales.lists_prog2.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
public class Gender1 {
    @NotNull
    @NotEmpty
    private String code;
    @NotNull
    @NotEmpty
    private String description;
}
