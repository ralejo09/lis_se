package com.umanizales.lists_prog2.controller.dto;

import com.umanizales.lists_prog2.model.Location;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
/**
 * clase creada para obtener generos por la localizacion y poder generar la estructura de respuesta
 * @author Alejo Carmona
 * @version 1.0 - 2-nov-2021
 */
public class GenderByLocationDTO {
    /**
     * atributo de locaclizacion de tipo Localizacion
     */
    private Location location;
    /**
     * lista de generon por grados
     */
    private List<GradesByGenderDTO> gradesByGenderDTOS;
    /**
     * atributo para el total de niños por la localizacion
     */
    private  int total;
}
