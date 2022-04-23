package com.example.demo.core.geo;

import com.example.demo.core.util.PagingRequest;
import com.example.demo.core.util.PagingResponse;
import com.example.demo.domain.geo.City;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CityServiceQuery implements CityQuery {

    private final CityPersistencePort cityPersistencePort;

    @Override
    public PagingResponse<City> findAll(final PagingRequest pagingRequest) {
        return cityPersistencePort.findAll(pagingRequest);
    }
}
