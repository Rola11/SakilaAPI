package gov.iti.jets.service.interfaces;

import gov.iti.jets.service.dto.InventoryDto;

import java.util.List;

public interface InventoryServic {

    List<InventoryDto> getAll();

    InventoryDto getById(Integer id);

    void insert(InventoryDto inventoryDto);

    void update(InventoryDto inventoryDto);

    void delete(InventoryDto inventoryDto);
}
