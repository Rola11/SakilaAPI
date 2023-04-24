package gov.iti.jets.service.mapper;

import gov.iti.jets.service.dto.CityDto;
import gov.iti.jets.entity.City;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;


@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.CDI, uses = {CountryMapper.class})
public interface CityMapper {
    CityMapper INSTANCE = Mappers.getMapper(CityMapper.class);
    City toEntity(CityDto cityDto);

    CityDto toDto(City city);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    City partialUpdate(CityDto cityDto, @MappingTarget City city);
}