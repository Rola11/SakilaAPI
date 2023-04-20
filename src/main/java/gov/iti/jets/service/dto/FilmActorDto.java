package gov.iti.jets.service.dto;

import gov.iti.jets.entity.Actor;
import gov.iti.jets.entity.FilmActorId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.Instant;

/**
 * A DTO for the {@link gov.iti.jets.entity.FilmActor} entity
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FilmActorDto implements Serializable {
    private FilmActorId id;
    private Actor actor;
    private FilmDto film;
    private Instant lastUpdate;
}