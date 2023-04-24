package gov.iti.jets.service.mapper;

import gov.iti.jets.service.dto.RentalDto;
import gov.iti.jets.entity.Rental;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.CDI, uses = {InventoryMapper.class, StaffMapper.class})
public interface RentalMapper {
    RentalMapper INSTANCE = Mappers.getMapper(RentalMapper.class);
    Rental toEntity(RentalDto rentalDto);

    RentalDto toDto(Rental rental);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Rental partialUpdate(RentalDto rentalDto, @MappingTarget Rental rental);
}