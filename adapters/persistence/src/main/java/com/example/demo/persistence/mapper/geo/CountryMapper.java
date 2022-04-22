package com.example.demo.persistence.mapper.geo;

import com.example.demo.domain.geo.Country;
import com.example.demo.persistence.model.geo.JpaCountry;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CountryMapper {

    CountryMapper COUNTRY_JPA_ADAPTER_MAPPER = Mappers.getMapper(CountryMapper.class);

    @Mappings({
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "alpha2", target = "alpha2"),
            @Mapping(source = "alpha3", target = "alpha3"),
            @Mapping(source = "name", target = "name"),
            @Mapping(source = "active", target = "active")
    })
    Country entityToDomain(JpaCountry entity);

    @Mappings({
            @Mapping(source = "alpha2", target = "alpha2"),
            @Mapping(source = "alpha3", target = "alpha3"),
            @Mapping(source = "name", target = "name"),
            @Mapping(source = "active", target = "active")
    })
    JpaCountry domainToEntity(Country domain);
}
