package gov.iti.jets.dao.imple;


import jakarta.persistence.EntityManager;
import gov.iti.jets.entity.Actor;

public class ActorDao extends GenericDao<Integer, Actor> {

    public ActorDao(EntityManager entityManager){
        super( entityManager,Actor.class);
    }

}
