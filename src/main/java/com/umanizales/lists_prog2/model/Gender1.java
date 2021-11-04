package com.umanizales.lists_prog2.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
/**
 * Clase creada para generar los generos que queramos por codigo y su descripcion(nombre del genero)
 * Tiene campos obligatorios como lo son el codigo y la descripcion
 * @author Alejo Carmona
 * @version 1.0 - 2-nov-2021
 */
public class Gender1 {
    @NotNull
    @NotEmpty
    /**
     * atributo creado para darle un codigo al genero
     */
    private String code;
    @NotNull
    @NotEmpty
    /**
     * atributo creado para darle una descripcion o nombre al genero
     */
    private String description;
}
