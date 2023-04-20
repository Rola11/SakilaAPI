package gov.iti.jets.dao.imple;

import gov.iti.jets.entity.Store;
import jakarta.persistence.EntityManager;

public class StoreDao extends GenericDao<Integer, Store>{

    public StoreDao(EntityManager entityManager){
        super(entityManager,Store.class);
    }
}
