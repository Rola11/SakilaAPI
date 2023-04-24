package gov.iti.jets.service.interfaces;

import gov.iti.jets.service.dto.CategoryDto;
import gov.iti.jets.service.dto.FilmDto;

import java.util.List;

public interface CategoryServic {

    List<CategoryDto> getAll();

    CategoryDto getById(Integer id);

    void insert(CategoryDto categoryDto);

    void update(CategoryDto categoryDto);

    void delete(CategoryDto categoryDto);

    // List<FilmDto> getCategoryForActor(CategoryDto categoryDto);
}
