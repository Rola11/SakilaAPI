package gov.iti.jets.service.dto;

import gov.iti.jets.entity.Customer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.Instant;

/**
 * A DTO for the {@link gov.iti.jets.entity.Rental} entity
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RentalDto implements Serializable {
    private Integer id;
    private Instant rentalDate;
    private InventoryDto inventory;
    private Customer customer;
    private Instant returnDate;
    private StaffDto staff;
    private Instant lastUpdate;
}