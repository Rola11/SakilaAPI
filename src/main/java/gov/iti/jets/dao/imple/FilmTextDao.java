package gov.iti.jets.dao.imple;

import gov.iti.jets.entity.FilmText;
import jakarta.persistence.EntityManager;

public class FilmTextDao extends GenericDao<Integer, FilmText>{

    public FilmTextDao(EntityManager entityManager){
        super(entityManager,FilmText.class);
    }
}
