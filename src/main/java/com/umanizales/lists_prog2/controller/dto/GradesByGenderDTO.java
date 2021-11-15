package com.umanizales.lists_prog2.controller.dto;

import com.umanizales.lists_prog2.model.Gender;
import com.umanizales.lists_prog2.model.Gender1;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
/**
 * clase creada para obtener grados por genero y poder generar la estructura de respuesta
 * @author Alejo Carmona
 * @version 1.0 - 2-nov-2021
 */
public class GradesByGenderDTO {
    /**
     * atributo de tipo Gerero1 que nos da los generos
     */
    private Gender1 gender;
    /**
     * atributo que nos lanza un arreglo de grados
     */
    private RhByGradesDTO[] rhByGradesDTOS;
    //private List<RhByGradesDTO> rhByGradesDTOS;
}
