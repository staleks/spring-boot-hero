package com.example.demo.core;

import com.example.demo.domain.geo.Country;

public interface CountryPersistencePort {
    Country create(final Country country);
}
