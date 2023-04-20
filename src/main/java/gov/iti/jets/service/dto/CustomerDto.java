package gov.iti.jets.service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.Instant;

/**
 * A DTO for the {@link gov.iti.jets.entity.Customer} entity
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDto implements Serializable {
    private Integer id;
    private StoreDto store;
    private String firstName;
    private String lastName;
    private String email;
    private AddressDto address;
    private Boolean active = false;
    private Instant createDate;
    private Instant lastUpdate;
}