package gov.iti.jets.service.interfaces;

import gov.iti.jets.service.dto.PaymentDto;

import java.util.List;

public interface PaymentServic {

    List<PaymentDto> getAll();

    PaymentDto getById(Integer id);

    void insert(PaymentDto paymentDto);

    void update(PaymentDto paymentDto);

    void delete(PaymentDto paymentDto);
}
