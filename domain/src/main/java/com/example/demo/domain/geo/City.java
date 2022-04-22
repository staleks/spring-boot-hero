package com.example.demo.domain.geo;

import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
public class City {

    private Long id;
    private String zipCode;
    private String name;
    private boolean active;
    private Country country;

    private City(final String zipCode, final String name, final Country country) {
        this.zipCode = zipCode;
        this.name = name;
        this.country = country;
        this.active = Boolean.TRUE;
    }

    public static City create(final String zipCode, final String name, final Country country) {
        return new City(zipCode, name, country);
    }

}
