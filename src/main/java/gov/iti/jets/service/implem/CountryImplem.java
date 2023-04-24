package gov.iti.jets.service.implem;

import gov.iti.jets.dao.imple.CountryDao;
import gov.iti.jets.entity.Country;
import gov.iti.jets.service.dto.CountryDto;
import gov.iti.jets.service.interfaces.CountryServic;
import gov.iti.jets.service.mapper.CountryMapper;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class CountryImplem implements CountryServic {

    public static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("rsa");
    public static EntityManager entityManager = entityManagerFactory.createEntityManager();

    CountryDao countryDao = new CountryDao(entityManager);
    CountryMapper countryMapper = CountryMapper.INSTANCE;
    @Override
    public List<CountryDto> getAll() {

        List<Country> listOfCountry = countryDao.getAll();
        List<CountryDto> listOfCountryDto = new ArrayList<>();
        for (Country country : listOfCountry){
            listOfCountryDto.add(countryMapper.toDto(country));
        }
        return listOfCountryDto;
    }

    @Override
    public CountryDto getById(Integer id) {
        return countryMapper.toDto(countryDao.getById(id));
    }

    @Override
    public void insert(CountryDto countryDto) {
        countryDto.setLastUpdate(Instant.now());
        countryDao.insert(countryMapper.toEntity(countryDto));
    }

    @Override
    public void update(CountryDto countryDto) {
        countryDto.setLastUpdate(Instant.now());
        countryDao.update(countryMapper.toEntity(countryDto));
    }

    @Override
    public void delete(CountryDto countryDto) {
            countryDao.delete(countryDao.getById(countryDto.getId()));
    }
}
