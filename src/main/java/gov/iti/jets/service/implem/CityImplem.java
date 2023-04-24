package gov.iti.jets.service.implem;

import gov.iti.jets.dao.imple.CityDao;
import gov.iti.jets.entity.City;
import gov.iti.jets.service.dto.CityDto;
import gov.iti.jets.service.interfaces.CityServic;
import gov.iti.jets.service.mapper.CityMapper;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class CityImplem implements CityServic {

    public static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("rsa");
    public static EntityManager entityManager = entityManagerFactory.createEntityManager();

    CityDao cityDao = new CityDao(entityManager);
    CityMapper cityMapper = CityMapper.INSTANCE;
    @Override
    public List<CityDto> getAll() {

        List<City> listOfCity = cityDao.getAll();
        List<CityDto> listOfCityDto = new ArrayList<>();
        for (City city : listOfCity){
            listOfCityDto.add(cityMapper.toDto(city));
        }
        return listOfCityDto;
    }

    @Override
    public CityDto getById(Integer id) {
        return cityMapper.toDto(cityDao.getById(id));
    }

    @Override
    public void insert(CityDto cityDto) {
            cityDto.setLastUpdate(Instant.now());
            cityDao.insert(cityMapper.toEntity(cityDto));
    }

    @Override
    public void update(CityDto cityDto) {
            cityDto.setLastUpdate(Instant.now());
            cityDao.insert(cityMapper.toEntity(cityDto));
    }

    @Override
    public void delete(CityDto cityDto) {
            cityDao.delete(cityDao.getById(cityDto.getId()));
    }
}
