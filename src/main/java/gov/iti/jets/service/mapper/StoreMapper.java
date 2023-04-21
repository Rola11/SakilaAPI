package gov.iti.jets.service.mapper;

import gov.iti.jets.entity.Store;
import gov.iti.jets.service.dto.StoreDto;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.CDI, uses = {StaffMapper.class, AddressMapper.class})
public interface StoreMapper {
    Store toEntity(StoreDto storeDto);

    StoreDto toDto(Store store);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Store partialUpdate(StoreDto storeDto, @MappingTarget Store store);
}