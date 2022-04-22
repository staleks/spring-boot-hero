package com.example.demo.core;

import com.example.demo.domain.geo.Country;

public interface CreateCountryUseCase {
    Country createCountry(final String alpha2, final String alpha3, final String name);
}
