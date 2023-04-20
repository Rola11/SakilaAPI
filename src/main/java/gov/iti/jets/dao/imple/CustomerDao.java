package gov.iti.jets.dao.imple;

import gov.iti.jets.entity.Customer;
import jakarta.persistence.EntityManager;

public class CustomerDao extends GenericDao<Integer, Customer>{

    public CustomerDao(EntityManager entityManager){
        super(entityManager,Customer.class);
    }
}
