package gov.iti.jets.service.mapper;

import gov.iti.jets.service.dto.FilmCategoryIdDto;
import gov.iti.jets.entity.FilmCategoryId;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;


@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.CDI)
public interface FilmCategoryIdMapper {
    FilmCategoryIdMapper INSTANCE = Mappers.getMapper(FilmCategoryIdMapper.class);
    FilmCategoryId toEntity(FilmCategoryIdDto filmCategoryIdDto);

    FilmCategoryIdDto toDto(FilmCategoryId filmCategoryId);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    FilmCategoryId partialUpdate(FilmCategoryIdDto filmCategoryIdDto, @MappingTarget FilmCategoryId filmCategoryId);
}