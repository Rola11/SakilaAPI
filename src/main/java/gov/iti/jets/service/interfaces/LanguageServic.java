package gov.iti.jets.service.interfaces;

import gov.iti.jets.service.dto.LanguageDto;

import java.util.List;

public interface LanguageServic {

    List<LanguageDto> getAll();

    LanguageDto getById(Integer id);

    void insert(LanguageDto languageDto);

    void update(LanguageDto languageDto);

    void delete(LanguageDto languageDto);
}
