package gov.iti.jets.service.mapper;

import gov.iti.jets.service.dto.FilmActorDto;
import gov.iti.jets.entity.FilmActor;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.CDI, uses = {FilmMapper.class})
public interface FilmActorMapper {
    FilmActor toEntity(FilmActorDto filmActorDto);

    FilmActorDto toDto(FilmActor filmActor);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    FilmActor partialUpdate(FilmActorDto filmActorDto, @MappingTarget FilmActor filmActor);
}