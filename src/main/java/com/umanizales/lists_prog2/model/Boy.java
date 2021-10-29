package com.umanizales.lists_prog2.model;

import lombok.*;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Setter
@Getter
public class Boy {
    @NotNull
    @NotEmpty
    @Size(min=2, max = 8)
    private String identification;
    @NotNull
    @NotEmpty
    @Size(min=2, max = 50)
    private String name;
    @Positive

    private byte age;
    @Valid
    @NotNull
    private Gender1 gender;
    @Valid
    @NotNull
    private Location location;
}
