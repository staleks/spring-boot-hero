package com.example.demo.core;

import com.example.demo.core.util.PagingRequest;
import com.example.demo.core.util.PagingResponse;
import com.example.demo.domain.geo.Country;

import java.util.Optional;

public interface CountryPersistencePort {
    Optional<Country> findById(final Long countryId);

    PagingResponse<Country> findAll(final PagingRequest pagingRequest);

    Country create(final Country country);
}
