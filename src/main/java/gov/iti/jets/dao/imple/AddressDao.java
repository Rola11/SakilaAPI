package gov.iti.jets.dao.imple;

import gov.iti.jets.entity.Address;

import jakarta.persistence.EntityManager;

public class AddressDao extends GenericDao<Integer, Address>{

    public AddressDao(EntityManager entityManager){
        super(entityManager,Address.class);
    }
}
