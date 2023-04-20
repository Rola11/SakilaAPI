package gov.iti.jets.dao.imple;

import gov.iti.jets.entity.Inventory;
import jakarta.persistence.EntityManager;

public class InventoryDao extends GenericDao<Integer, Inventory>{

    public InventoryDao(EntityManager entityManager){
        super(entityManager,Inventory.class);
    }
}
