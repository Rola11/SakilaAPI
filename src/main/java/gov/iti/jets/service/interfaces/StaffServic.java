package gov.iti.jets.service.interfaces;

import gov.iti.jets.service.dto.StaffDto;

import java.util.List;

public interface StaffServic {

    List<StaffDto> getAll();

    StaffDto getById(Integer id);

    void insert(StaffDto staffDto);

    void update(StaffDto staffDto);

    void delete(StaffDto staffDto);
}
