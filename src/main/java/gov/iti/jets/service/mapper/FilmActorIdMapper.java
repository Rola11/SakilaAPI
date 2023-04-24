package gov.iti.jets.service.mapper;

import gov.iti.jets.service.dto.FilmActorIdDto;
import gov.iti.jets.entity.FilmActorId;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;


@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.CDI)
public interface FilmActorIdMapper {
    FilmActorIdMapper INSTANCE = Mappers.getMapper(FilmActorIdMapper.class);
    FilmActorId toEntity(FilmActorIdDto filmActorIdDto);

    FilmActorIdDto toDto(FilmActorId filmActorId);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    FilmActorId partialUpdate(FilmActorIdDto filmActorIdDto, @MappingTarget FilmActorId filmActorId);
}