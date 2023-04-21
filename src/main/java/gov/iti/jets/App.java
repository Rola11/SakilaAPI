package gov.iti.jets;

import gov.iti.jets.dao.imple.ActorDao;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class App {

    public static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("rsa");
    public static EntityManager entityManager = entityManagerFactory.createEntityManager();

    public static void main(String[] args){

        ActorDao actorDao = new ActorDao(entityManager);
        System.out.println(actorDao.getById(132).getFirstName());
    }
}
