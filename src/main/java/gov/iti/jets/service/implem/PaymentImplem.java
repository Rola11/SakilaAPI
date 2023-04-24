package gov.iti.jets.service.implem;

import gov.iti.jets.dao.imple.LanguageDao;
import gov.iti.jets.dao.imple.PaymentDao;
import gov.iti.jets.entity.Payment;
import gov.iti.jets.service.dto.PaymentDto;
import gov.iti.jets.service.interfaces.PaymentServic;
import gov.iti.jets.service.mapper.LanguageMapper;
import gov.iti.jets.service.mapper.PaymentMapper;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class PaymentImplem implements PaymentServic {
    public static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("rsa");
    public static EntityManager entityManager = entityManagerFactory.createEntityManager();
    PaymentDao paymentDao = new PaymentDao(entityManager);
    PaymentMapper paymentMapper = PaymentMapper.INSTANCE;

    @Override
    public List<PaymentDto> getAll() {
        List<Payment>listOfPayment = paymentDao.getAll();
        List<PaymentDto>listOfPaymentDto = new ArrayList<>();
        for (Payment payment : listOfPayment){
            listOfPaymentDto.add(paymentMapper.toDto(payment));
        }
        return listOfPaymentDto;
    }

    @Override
    public PaymentDto getById(Integer id) {
        return paymentMapper.toDto(paymentDao.getById(id));
    }

    @Override
    public void insert(PaymentDto paymentDto) {
            paymentDto.setLastUpdate(Instant.now());
            paymentDto.setPaymentDate(Instant.now());
            paymentDao.insert(paymentMapper.toEntity(paymentDto));
    }

    @Override
    public void update(PaymentDto paymentDto) {
            paymentDto.setLastUpdate(Instant.now());
            paymentDto.setPaymentDate(Instant.now());
            paymentDao.update(paymentMapper.toEntity(paymentDto));
    }

    @Override
    public void delete(PaymentDto paymentDto) {
            paymentDao.delete(paymentDao.getById(paymentDto.getId()));
    }
}
