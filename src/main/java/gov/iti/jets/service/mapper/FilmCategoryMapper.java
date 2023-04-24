package gov.iti.jets.service.mapper;

import gov.iti.jets.service.dto.FilmCategoryDto;
import gov.iti.jets.entity.FilmCategory;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;


@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.CDI)
public interface FilmCategoryMapper {
    FilmCategoryMapper INSTANCE = Mappers.getMapper(FilmCategoryMapper.class);
    FilmCategory toEntity(FilmCategoryDto filmCategoryDto);

    FilmCategoryDto toDto(FilmCategory filmCategory);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    FilmCategory partialUpdate(FilmCategoryDto filmCategoryDto, @MappingTarget FilmCategory filmCategory);
}