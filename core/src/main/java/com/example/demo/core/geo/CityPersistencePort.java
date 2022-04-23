package com.example.demo.core.geo;

import com.example.demo.core.util.PagingRequest;
import com.example.demo.core.util.PagingResponse;
import com.example.demo.domain.geo.City;
import com.example.demo.domain.geo.Country;

public interface CityPersistencePort {
    PagingResponse<City> findAll(final PagingRequest pagingRequest);
}
