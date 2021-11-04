package com.umanizales.lists_prog2.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
/**
 * Clase creada para que me cuente con niños o niñas por el genero
 * @author Alejo Carmona
 * @version 1.0 - 2-nov-2021
 */
public class BoysByGender {
    /**
     * atributo creado para saber el genero
     */
    private Gender1 gender;
    /**
     * atributo creado para que me cuente los niños o niñas por el genero
     */
    private int count;
}
