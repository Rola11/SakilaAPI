package gov.iti.jets.service.interfaces;

import java.util.List;
import gov.iti.jets.service.dto.AddressDto;

public interface AddressServic {

    List<AddressDto> getAll();

    AddressDto getById(Integer id);

    void insert(AddressDto addressDto);

    void update(AddressDto addressDto);

    void delete(AddressDto addressDto);

}
