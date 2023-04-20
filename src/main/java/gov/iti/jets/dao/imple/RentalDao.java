package gov.iti.jets.dao.imple;

import gov.iti.jets.entity.Rental;
import jakarta.persistence.EntityManager;

public class RentalDao extends GenericDao<Integer, Rental>{

    public RentalDao(EntityManager entityManager){
        super(entityManager,Rental.class);
    }
}
