package gov.iti.jets.dao.imple;

import gov.iti.jets.entity.Staff;
import jakarta.persistence.EntityManager;

public class StaffDao extends GenericDao<Integer, Staff>{

    public StaffDao(EntityManager entityManager){
        super(entityManager,Staff.class);
    }
}
