package gov.iti.jets.service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.Instant;

/**
 * A DTO for the {@link gov.iti.jets.entity.Country} entity
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CountryDto implements Serializable {
    private Integer id;
    private String country;
    private Instant lastUpdate;
}