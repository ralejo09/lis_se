package com.umanizales.lis_se.model;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Setter
@Getter
public class Boy {
    private String identification;
    private String name;
    private byte age;
    private String gender;
    private String municipio;
}
