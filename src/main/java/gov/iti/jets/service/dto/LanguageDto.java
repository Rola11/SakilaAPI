package gov.iti.jets.service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.Instant;

/**
 * A DTO for the {@link gov.iti.jets.entity.Language} entity
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LanguageDto implements Serializable {
    private Short id;
    private String name;
    private Instant lastUpdate;
}