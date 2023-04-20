package gov.iti.jets.service.mapper;

import gov.iti.jets.service.dto.StoreDto;
import gov.iti.jets.entity.Store;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.CDI, uses = {AddressMapper.class})
public interface StoreMapper {
    @Mapping(source = "Staff", target = "managerStaff")
    Store toEntity(StoreDto storeDto);

    @Mapping(source = "managerStaff", target = "Staff")
    StoreDto toDto(Store store);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(source = "Staff", target = "managerStaff")
    Store partialUpdate(StoreDto storeDto, @MappingTarget Store store);
}