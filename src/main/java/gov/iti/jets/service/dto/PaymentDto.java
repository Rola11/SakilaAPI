package gov.iti.jets.service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.Instant;

/**
 * A DTO for the {@link gov.iti.jets.entity.Payment} entity
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaymentDto implements Serializable {
    private Integer id;
    private CustomerDto customer;
    private StaffDto staff;
    private RentalDto rental;
    private BigDecimal amount;
    private Instant paymentDate;
    private Instant lastUpdate;
}