package gov.iti.jets.dao.imple;

import gov.iti.jets.entity.Language;
import jakarta.persistence.EntityManager;

public class LanguageDao extends GenericDao<Integer, Language>{

    public LanguageDao(EntityManager entityManager){
        super(entityManager,Language.class);
    }
}
