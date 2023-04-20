package gov.iti.jets.dao.imple;

import gov.iti.jets.entity.Payment;
import jakarta.persistence.EntityManager;

public class PaymentDao extends GenericDao<Integer, Payment>{

    public PaymentDao(EntityManager entityManager){
        super(entityManager,Payment.class);
    }
}
