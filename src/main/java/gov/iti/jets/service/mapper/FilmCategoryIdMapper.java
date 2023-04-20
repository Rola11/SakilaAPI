package gov.iti.jets.service.mapper;

import gov.iti.jets.service.dto.FilmCategoryIdDto;
import gov.iti.jets.entity.FilmCategoryId;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.CDI)
public interface FilmCategoryIdMapper {
    FilmCategoryId toEntity(FilmCategoryIdDto filmCategoryIdDto);

    FilmCategoryIdDto toDto(FilmCategoryId filmCategoryId);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    FilmCategoryId partialUpdate(FilmCategoryIdDto filmCategoryIdDto, @MappingTarget FilmCategoryId filmCategoryId);
}