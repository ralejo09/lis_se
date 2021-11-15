package com.umanizales.lists_prog2.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
/**
 * clase creada para obtener una respuesta a nuestra consulta poder generar la estructura de respuesta
 * @author Alejo Carmona
 * @version 1.0 - 2-nov-2021
 */
public class ResponseDTO {
    /**
     * atributo que nos da el mensaje que se quiera responder
     */
    private String message;
    /**
     * atributo que nos muestra la estructura, mensaje, lista
      */
    private Object data;
    /**
     * atributo que nos muestra una lista de errores
     */
    private List<ErrorDTO> errors;
}
