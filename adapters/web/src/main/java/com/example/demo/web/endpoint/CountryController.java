package com.example.demo.web.endpoint;

import com.example.demo.core.geo.CountryQuery;
import com.example.demo.core.geo.CreateCountryUseCase;
import com.example.demo.domain.geo.Country;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.ResponseEntity.notFound;

@RestController
@RequiredArgsConstructor
public class CountryController {

    private static final String COUNTRIES_ENDPOINT = "/geo/countries";
    private static final String COUNTRIES_ENDPOINT_FOR_ID = "/geo/countries/{countryId}";

    private final CountryQuery countryQuery;
    private final CreateCountryUseCase createCountryUseCase;

    @GetMapping(value = COUNTRIES_ENDPOINT_FOR_ID, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Country> handleGetOne(@PathVariable("countryId") Long countryId) {
        return countryQuery.findById(countryId)
                .map(ResponseEntity::ok)
                .orElseGet(() -> notFound().build());
    }


}
