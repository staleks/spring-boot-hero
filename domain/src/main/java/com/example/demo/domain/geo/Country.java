package com.example.demo.domain.geo;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Country {

    private Long id;
    private String alpha2;
    private String alpha3;
    private String name;
    private boolean active;

    private Country(final String alpha2, final String alpha3, final String name) {
        this.alpha2 = alpha2;
        this.alpha3 = alpha3;
        this.name = name;
        this.active = Boolean.TRUE;
    }

    public static Country create(final String alpha2, final String alpha3, final String name) {
        return new Country(alpha2, alpha3, name);
    }

}
