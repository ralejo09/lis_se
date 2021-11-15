package com.umanizales.lists_prog2.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
/**
 * clase creada para mostrar los grados de los niños y poder contar la cantidad de niños por grado
 * @author Alejo Carmona
 * @version 1.0 - 2-nov-2021
 */
public class BoysByGrade {
    /**
     * atributo creados para los grados
     */
    private int grade;
    /**
     * atrubuto creado para contar los niños por grado
     */
    private int count;
}
