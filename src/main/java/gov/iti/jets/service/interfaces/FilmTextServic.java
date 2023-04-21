package gov.iti.jets.service.interfaces;

import gov.iti.jets.service.dto.FilmTextDto;

import java.util.List;

public interface FilmTextServic {

    List<FilmTextDto> getAll();

    FilmTextDto getById(Integer id);

    void insert(FilmTextDto filmTextDto);

    void update(FilmTextDto filmTextDto);

    void delete(FilmTextDto filmTextDto);
}
