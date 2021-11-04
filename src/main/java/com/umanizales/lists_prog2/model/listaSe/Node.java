package com.umanizales.lists_prog2.model.listaSe;

import com.umanizales.lists_prog2.model.Boy;
import lombok.Data;

@Data
/**
 * Clase nodo es donde guardamos los datos
 * se crean dos atributos un nodo que almacena datos y un next que es como si tubiera un bracito
 * que agarra al dato siguiente
 */
public class Node {
    /**
     * se crea el atributo data que almacena los datos de 1 niño
     */
    private Boy data;
    /**
     * se crea el atributo next que se va a encargar de agarrar los otros datos
     */
    private Node next;

    /**
     * generamos un constructor para cuando se inicialice la clase data si o si tenga que tener todos los datos
     * @param data
     */
    public Node(Boy data) {
        this.data = data;
    }
}
