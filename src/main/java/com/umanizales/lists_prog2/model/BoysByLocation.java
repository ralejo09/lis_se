package com.umanizales.lists_prog2.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
/**
 * Clase creada para que me cuente con niños o niñas por la localizacion o ubicacion
 * @author Alejo Carmona
 * @version 1.0 - 2-nov-2021
 */
public class BoysByLocation {
    /**
     * atributo creado para saber la localizacion
     */
    private Location location;
    /**
     * atributo creado para contor los niños o niñas por la localizacion
     */
    private int count;
}
