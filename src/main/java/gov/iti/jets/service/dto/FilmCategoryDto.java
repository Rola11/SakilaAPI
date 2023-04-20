package gov.iti.jets.service.dto;

import gov.iti.jets.entity.Category;
import gov.iti.jets.entity.Film;
import gov.iti.jets.entity.FilmCategoryId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.Instant;

/**
 * A DTO for the {@link gov.iti.jets.entity.FilmCategory} entity
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FilmCategoryDto implements Serializable {
    private FilmCategoryId id;
    private Film film;
    private Category category;
    private Instant lastUpdate;
}