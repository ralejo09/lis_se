package com.umanizales.lists_prog2.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
/**
 * clase creada para obtener una respuesta a los errores y poder generar la estructura de respuesta
 * @author Alejo Carmona
 * @version 1.0 - 2-nov-2021
 */
public class ErrorDTO {
    /**
     * atributo que nos da el codigo del error
     */
    private int code;
    /**
     * atributo que nos muestra el mensaje del error
     */
    private String message;
}
