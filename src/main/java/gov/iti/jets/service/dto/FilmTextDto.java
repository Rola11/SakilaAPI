package gov.iti.jets.service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * A DTO for the {@link gov.iti.jets.entity.FilmText} entity
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FilmTextDto implements Serializable {
    private Short id;
    private String title;
    private String description;
}