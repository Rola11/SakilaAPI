package gov.iti.jets.service.interfaces;

import gov.iti.jets.service.dto.StoreDto;

import java.util.List;

public interface StoreServic {

    List<StoreDto> getAll();

    StoreDto getById(Integer id);

    void insert(StoreDto storeDto);

    void update(StoreDto storeDto);

    void delete(StoreDto storeDto);
}
