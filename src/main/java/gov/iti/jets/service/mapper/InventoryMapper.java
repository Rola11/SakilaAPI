package gov.iti.jets.service.mapper;

import gov.iti.jets.service.dto.InventoryDto;
import gov.iti.jets.entity.Inventory;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.CDI, uses = {FilmMapper.class, StoreMapper.class})
public interface InventoryMapper {
    InventoryMapper INSTANCE = Mappers.getMapper(InventoryMapper.class);
    Inventory toEntity(InventoryDto inventoryDto);

    InventoryDto toDto(Inventory inventory);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Inventory partialUpdate(InventoryDto inventoryDto, @MappingTarget Inventory inventory);
}