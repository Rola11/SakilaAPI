package gov.iti.jets.service.implem;

import gov.iti.jets.dao.imple.FilmDao;
import gov.iti.jets.dao.imple.FilmTextDao;
import gov.iti.jets.entity.FilmText;
import gov.iti.jets.service.dto.FilmTextDto;
import gov.iti.jets.service.interfaces.FilmTextServic;
import gov.iti.jets.service.mapper.FilmMapper;
import gov.iti.jets.service.mapper.FilmTextMapper;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.ArrayList;
import java.util.List;

public class FilmTextImplem implements FilmTextServic {
    public static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("rsa");
    public static EntityManager entityManager = entityManagerFactory.createEntityManager();
    FilmTextDao filmTextDao = new FilmTextDao(entityManager);
    FilmTextMapper filmTextMapper = FilmTextMapper.INSTANCE;
    @Override
    public List<FilmTextDto> getAll() {
        List<FilmText> listOfFilmText = filmTextDao.getAll();
        List<FilmTextDto> listOfFilmTextDto = new ArrayList<>();
        for (FilmText filmText : listOfFilmText) {
            listOfFilmTextDto.add(filmTextMapper.toDto(filmText));
        }
        return listOfFilmTextDto;

    }

    @Override
    public FilmTextDto getById(Integer id) {
        return filmTextMapper.toDto(filmTextDao.getById(id));
    }

    @Override
    public void insert(FilmTextDto filmTextDto) {
        filmTextDao.insert(filmTextMapper.toEntity(filmTextDto));
    }

    @Override
    public void update(FilmTextDto filmTextDto) {
        filmTextDao.update(filmTextMapper.toEntity(filmTextDto));
    }

    @Override
    public void delete(FilmTextDto filmTextDto) {
        filmTextDao.delete(filmTextDao.getById(Integer.valueOf(filmTextDto.getId())));
    }
}
