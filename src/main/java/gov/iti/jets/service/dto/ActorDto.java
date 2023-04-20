package gov.iti.jets.service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.Instant;

/**
 * A DTO for the {@link gov.iti.jets.entity.Actor} entity
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ActorDto implements Serializable {
    private Integer id;
    private String firstName;
    private String lastName;
    private Instant lastUpdate;
}