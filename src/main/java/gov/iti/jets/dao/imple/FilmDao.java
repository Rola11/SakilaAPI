package gov.iti.jets.dao.imple;

import gov.iti.jets.entity.Film;
import jakarta.persistence.EntityManager;

public class FilmDao extends GenericDao<Integer, Film>{

    public FilmDao(EntityManager entityManager){
        super(entityManager,Film.class);
    }
}
