package com.umanizales.lists_prog2.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
/**
 * clase creada para contar por el genero poder generar la estructura de respuesta
 * @author Alejo Carmona
 * @version 1.0 - 2-nov-2021
 */
public class CountByGenderDTO {
    /**
     * atributo de genero
     */
    private String gender;
    /**
     * atributo que nos cuenta cuantos niños hay de cada genero
     */
    private int count;
}
