package gov.iti.jets.service.interfaces;

import gov.iti.jets.service.dto.ActorDto;
import gov.iti.jets.service.dto.CategoryDto;
import gov.iti.jets.service.dto.FilmDto;

import java.util.List;

public interface FilmServic {

    List<FilmDto> getAll();

    FilmDto getById(Integer id);

    void insert(FilmDto filmDto);

    void update(FilmDto filmDto);

    void delete(FilmDto filmDto);

    //List<ActorDto> getActorsForFilm(FilmDto FilmDto);

    //List<CategoryDto> getCategoriesForFilm(FilmDto FilmDto);
}
