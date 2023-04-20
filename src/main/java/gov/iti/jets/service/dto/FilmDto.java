package gov.iti.jets.service.dto;

import gov.iti.jets.entity.Language;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.Instant;

/**
 * A DTO for the {@link gov.iti.jets.entity.Film} entity
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FilmDto implements Serializable {
    private Integer id;
    private String title;
    private String description;
    private Integer releaseYear;
    private Language language;
    private Language originalLanguage;
    private Short rentalDuration;
    private BigDecimal rentalRate;
    private Integer length;
    private BigDecimal replacementCost;
    private String rating;
    private String specialFeatures;
    private Instant lastUpdate;
}