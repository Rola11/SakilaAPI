package gov.iti.jets.service.interfaces;

import gov.iti.jets.service.dto.RentalDto;

import java.util.List;

public interface RentalServic {

    List<RentalDto> getAll();

    RentalDto getById(Integer id);

    void insert(RentalDto rentalDto);

    void update(RentalDto rentalDto);

    void delete(RentalDto rentalDto);
}
