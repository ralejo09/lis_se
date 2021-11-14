package com.umanizales.lists_prog2.model;

import lombok.*;

import javax.validation.Valid;
import javax.validation.constraints.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Setter
@Getter
/**
 * Clase creada para almacenar los datos de un niño (Identificacion, nombre, edad, genero, localizacion)
 * Tiene campos que son obligatorios como lo son (Identificacion, nombre, genero, localizacion)
 * Y tambien un campo que debe tener un numero positivo (edad)
 * @author Alejo Carmona
 * @version 1.0 - 2-nov-2021
 */
public class Boy {
    @NotNull
    @NotEmpty
    @Size(min=2, max = 8)
    /**
     * atributo identification esta creado para qie el niño que se cree tenga un dato unico
     */
    private String identification;
    @NotNull
    @NotEmpty
    @Size(min=2, max = 50)
    /**
     * atributo name creado para que el niño adicionado tenga un niño
     */
    private String name;
    @Positive
    /**
     * atributo age creado para que el niño se pueda identificar con una edad
     */
    private byte age;
    @Valid
    @NotNull
    /**
     * atributo gender creado para saber si estamos hablando de una niña o de un niño
     */
    private Gender1 gender;
    @Valid
    @NotNull
    /**
     * atributo creado para saber en donde se encuentra el niño o niña (cual es su ubicacion: manizales,pereira....)
     */
    private Location location;
    @NotNull
    @Positive
    @Max(value = 5,message = "Debe de ingresar un grado valido")
    //@Size(min=1, max = 5)
    /**
     * atributo creado para saber el grado en el que se encuentra el niño o niña (1,2,3,4,5)
     */
    @NotNull
    private byte grade;
    /**
     * atributo booleano de si es orphan o no
     */
    @NotNull
    private boolean orphan;
    /**
     * creamos un atributo string que sea el rh
     */
    @NotNull
    private String rh;
}
