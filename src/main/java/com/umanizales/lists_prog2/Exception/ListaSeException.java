package com.umanizales.lists_prog2.Exception;

/**
 * generar los mensajes a las respuestas de las excepciones de nuestras llistas SE enlazadas, esta clase hereda
 * de excepciones
 * @author Alejo Carmona
 * @version 1.0 - 2-nov-2021
 */
public class ListaSeException extends Exception{
    /**
     * generamos un constructor el cual nos pedira un mensaje como dato para retornarlo
     * @param message
     */
    public ListaSeException(String message) {
        super(message);
    }
}
