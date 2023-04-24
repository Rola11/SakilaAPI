package gov.iti.jets.service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.Instant;

/**
 * A DTO for the {@link gov.iti.jets.entity.Store} entity
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StoreDto implements Serializable {
    private Short id;
    private StaffDto managerStaff;
    private AddressDto address;
    private Instant lastUpdate;
}