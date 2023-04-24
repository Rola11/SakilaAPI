package gov.iti.jets.service.implem;

import gov.iti.jets.dao.imple.FilmDao;
import gov.iti.jets.entity.Film;
import gov.iti.jets.entity.FilmActor;
import gov.iti.jets.entity.FilmCategory;
import gov.iti.jets.service.dto.ActorDto;
import gov.iti.jets.service.dto.CategoryDto;
import gov.iti.jets.service.dto.FilmDto;
import gov.iti.jets.service.interfaces.FilmServic;
import gov.iti.jets.service.mapper.FilmMapper;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class FilmImplem implements FilmServic {
    public static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("rsa");
    public static EntityManager entityManager = entityManagerFactory.createEntityManager();
    FilmDao filmDao = new FilmDao(entityManager);
    FilmMapper filmMapper = FilmMapper.INSTANCE;
    @Override
    public List<FilmDto> getAll() {
        List<Film> listOfFilm = filmDao.getAll();
        List<FilmDto> listOfFilmDto  = new ArrayList<>();
        for(Film film : listOfFilm){
            listOfFilmDto.add(filmMapper.toDto(film));
        }
        return listOfFilmDto;
    }

    @Override
    public FilmDto getById(Integer id) {
        return filmMapper.toDto(filmDao.getById(id));
    }

    @Override
    public void insert(FilmDto filmDto) {
        filmDto.setLastUpdate(Instant.now());
        filmDao.insert(filmMapper.toEntity(filmDto));
    }

    @Override
    public void update(FilmDto filmDto) {
        filmDto.setLastUpdate(Instant.now());
        filmDao.update(filmMapper.toEntity(filmDto));
    }

    @Override
    public void delete(FilmDto filmDto) {
        filmDao.delete(filmDao.getById(filmDto.getId()));
    }

//    @Override
//    public List<ActorDto> getActorsForFilm(FilmDto FilmDto) {
//        List<FilmActor> listOfFilmActor = filmDao.getById(filmMapper.toEntity(FilmDto).getId()).getF
//        return null;
//    }

//    @Override
//    public List<CategoryDto> getCategoriesForFilm(FilmDto FilmDto) {
//       List<FilmCategory> listOfFilmCategory = filmDao.getById(filmMapper.toEntity(FilmDto).getId()).getF
//        return null;
//    }
}
