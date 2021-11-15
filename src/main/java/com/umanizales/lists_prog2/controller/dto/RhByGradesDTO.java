package com.umanizales.lists_prog2.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
/**
 * clase creada para obtener RH por el grado y poder generar la estructura de respuesta
 * @author Alejo Carmona
 * @version 1.0 - 2-nov-2021
 */
public class RhByGradesDTO {
    /**
     * atributo de grados
     */
    private byte grade;
    /**
     * atributo que nos da el rh
     */
    private String rh;
    /**
     * atributo que nos cuenta cuantos hay en ese grado
     */
    private int count;
}
