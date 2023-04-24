package gov.iti.jets.service.implem;

import gov.iti.jets.dao.imple.InventoryDao;
import gov.iti.jets.dao.imple.LanguageDao;
import gov.iti.jets.entity.Language;
import gov.iti.jets.service.dto.LanguageDto;
import gov.iti.jets.service.interfaces.LanguageServic;
import gov.iti.jets.service.mapper.InventoryMapper;
import gov.iti.jets.service.mapper.LanguageMapper;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class LanguageImplem implements LanguageServic {
    public static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("rsa");
    public static EntityManager entityManager = entityManagerFactory.createEntityManager();
    LanguageDao languageDao = new LanguageDao(entityManager);
    LanguageMapper languageMapper = LanguageMapper.INSTANCE;

    @Override
    public List<LanguageDto> getAll() {
        List<Language> listOfLanguage = languageDao.getAll();
        List<LanguageDto> listOfLanguageDto = new ArrayList<>();
        for (Language language : listOfLanguage) {
            listOfLanguageDto.add(languageMapper.toDto(language));
        }
        return listOfLanguageDto;
    }

    @Override
    public LanguageDto getById(Integer id) {
        return languageMapper.toDto(languageDao.getById(id));
    }

    @Override
    public void insert(LanguageDto languageDto) {
            languageDto.setLastUpdate(Instant.now());
            languageDao.insert(languageMapper.toEntity(languageDto));
    }

    @Override
    public void update(LanguageDto languageDto) {
            languageDto.setLastUpdate(Instant.now());
            languageDao.update(languageMapper.toEntity(languageDto));
    }

    @Override
    public void delete(LanguageDto languageDto) {
            languageDao.delete(languageDao.getById(Integer.valueOf(languageDto.getId())));
    }
}
