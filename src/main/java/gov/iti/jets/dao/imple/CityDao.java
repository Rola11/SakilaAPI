package gov.iti.jets.dao.imple;

import gov.iti.jets.entity.City;
import gov.iti.jets.entity.*;
import jakarta.persistence.EntityManager;

public class CityDao extends GenericDao<Integer, City>{
    public  CityDao(EntityManager entityManager){

        super(entityManager,City.class);
    }
}
