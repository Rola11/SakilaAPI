package gov.iti.jets.service.dto;

import gov.iti.jets.entity.City;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.Instant;

/**
 * A DTO for the {@link gov.iti.jets.entity.Address} entity
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddressDto implements Serializable {
    private Integer id;
    private String address;
    private String address2;
    private String district;
    private City city;
    private String postalCode;
    private String phone;
    private Instant lastUpdate;
}