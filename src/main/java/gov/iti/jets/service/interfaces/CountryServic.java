package gov.iti.jets.service.interfaces;

import gov.iti.jets.service.dto.CountryDto;

import java.util.List;

public interface CountryServic {

    List<CountryDto> getAll();

    CountryDto getById(Integer id);

    void insert(CountryDto countryDto);

    void update(CountryDto countryDto);

    void delete(CountryDto countryDto);
}
