package gov.iti.jets.service.mapper;

import gov.iti.jets.service.dto.ActorDto;
import gov.iti.jets.entity.Actor;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.CDI)
public interface ActorMapper {

    ActorMapper INSTANCE = Mappers.getMapper(ActorMapper.class);
    Actor toEntity(ActorDto actorDto);

    ActorDto toDto(Actor actor);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Actor partialUpdate(ActorDto actorDto, @MappingTarget Actor actor);
}