package gov.iti.jets.dao.imple;

import gov.iti.jets.entity.Country;
import jakarta.persistence.EntityManager;

public class CountryDao extends GenericDao<Integer, Country>{
    public CountryDao(EntityManager entityManager){
        super(entityManager,Country.class);
    }

}
