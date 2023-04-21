package gov.iti.jets.service.dto;

import lombok.Data;

import java.io.Serializable;
import java.time.Instant;

/**
 * A DTO for the {@link gov.iti.jets.entity.Store} entity
 */
@Data
public class StoreDto implements Serializable {
    private final Short id;
    private final StaffDto managerStaff;
    private final AddressDto address;
    private final Instant lastUpdate;
}