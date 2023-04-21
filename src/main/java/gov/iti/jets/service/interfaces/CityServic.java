package gov.iti.jets.service.interfaces;

import gov.iti.jets.service.dto.CityDto;
import java.util.List;

public interface CityServic {

    List<CityDto> getAll();

    CityDto getById(Integer id);

    void insert(CityDto cityDto);

    void update(CityDto cityDto);

    void delete(CityDto cityDto);
}
