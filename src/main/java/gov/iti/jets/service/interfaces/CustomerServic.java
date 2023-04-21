package gov.iti.jets.service.interfaces;

import gov.iti.jets.service.dto.CustomerDto;

import java.util.List;

public interface CustomerServic {

    List<CustomerDto> getAll();

    CustomerDto getById(Integer id);

    void insert(CustomerDto customerDto);

    void update(CustomerDto customerDto);

    void delete(CustomerDto customerDto);
}
