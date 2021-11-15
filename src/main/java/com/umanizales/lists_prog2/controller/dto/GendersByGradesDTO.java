package com.umanizales.lists_prog2.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
/**
 * clase creada para obtener generos por el grado y poder generar la estructura de respuesta
 * @author Alejo Carmona
 * @version 1.0 - 2-nov-2021
 */
public class GendersByGradesDTO {
    /**
     * creamos un atributo de grados
     */
    private byte grade;
    /**
     * creamos una lista donde pondremos el conteos de los generospor cada grado
     */
    private List<CountByGenderDTO> genders;
    /**
     * atributo que nos da el total de de niños por grado
     */
    private int total;
}
