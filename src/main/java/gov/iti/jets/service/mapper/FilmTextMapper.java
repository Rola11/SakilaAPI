package gov.iti.jets.service.mapper;

import gov.iti.jets.service.dto.FilmTextDto;
import gov.iti.jets.entity.FilmText;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;


@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.CDI)
public interface FilmTextMapper {
    FilmTextMapper INSTANCE = Mappers.getMapper(FilmTextMapper.class);
    FilmText toEntity(FilmTextDto filmTextDto);

    FilmTextDto toDto(FilmText filmText);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    FilmText partialUpdate(FilmTextDto filmTextDto, @MappingTarget FilmText filmText);
}