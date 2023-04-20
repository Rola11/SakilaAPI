package gov.iti.jets.dao.imple;

import gov.iti.jets.entity.*;

import jakarta.persistence.EntityManager;

public class CategoryDao extends GenericDao<Integer,Category>{

    public CategoryDao(EntityManager entityManager){
        super(entityManager,Category.class);
    }


}
