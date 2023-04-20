package gov.iti.jets.service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * A DTO for the {@link gov.iti.jets.entity.FilmActorId} entity
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FilmActorIdDto implements Serializable {
    private Integer actorId;
    private Integer filmId;
}