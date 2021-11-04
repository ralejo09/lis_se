package com.umanizales.lists_prog2.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
/**
 * Clase creada para generar las localizaciones que queramos por codigo y su descripcion(nombre de la localizacion)
 * Tiene campos obligatorios como lo son el codigo y la descripcion
 * @author Alejo Carmona
 * @version 1.0 - 2-nov-2021
 */
public class Location {
    @NotNull
    @NotEmpty
    /**
     * atributo creado para darle un codigo a la localizacion
     */
    private String code;
    @NotNull
    @NotEmpty
    /**
     * atributo creado para darle una descripcion o nombre a la localizacion
     */
    private String description;
}
