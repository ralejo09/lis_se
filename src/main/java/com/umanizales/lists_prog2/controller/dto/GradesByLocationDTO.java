package com.umanizales.lists_prog2.controller.dto;

import com.umanizales.lists_prog2.model.Location;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
/**
 * clase creada para obtener grados por la localizacion y poder generar la estructura de respuesta
 * @author Alejo Carmona
 * @version 1.0 - 2-nov-2021
 */
public class GradesByLocationDTO {
    /**
     * atributo que nos da la localizacion de tipo Localizacion
     */
    private Location location;
    /**
     * creamos una lista en donde se pondran los grados por cada genero
     */
    private List<GendersByGradesDTO> grades;
}
