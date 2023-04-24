package gov.iti.jets.service.implem;

import gov.iti.jets.dao.imple.PaymentDao;
import gov.iti.jets.dao.imple.RentalDao;
import gov.iti.jets.entity.Rental;
import gov.iti.jets.service.dto.RentalDto;
import gov.iti.jets.service.interfaces.RentalServic;
import gov.iti.jets.service.mapper.PaymentMapper;
import gov.iti.jets.service.mapper.RentalMapper;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class RentalImplem implements RentalServic {

    public static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("rsa");
    public static EntityManager entityManager = entityManagerFactory.createEntityManager();
    RentalDao rentalDao = new RentalDao(entityManager);
    RentalMapper rentalMapper = RentalMapper.INSTANCE;

    @Override
    public List<RentalDto> getAll() {
        List<Rental> listOfRental = rentalDao.getAll();
        List<RentalDto> listOfRentalDto = new ArrayList<>();
        for (Rental rental : listOfRental){
            listOfRentalDto.add(rentalMapper.toDto(rental));
        }
        return listOfRentalDto;
    }

    @Override
    public RentalDto getById(Integer id) {
        return rentalMapper.toDto(rentalDao.getById(id));
    }

    @Override
    public void insert(RentalDto rentalDto) {
            rentalDto.setLastUpdate(Instant.now());
            rentalDto.setRentalDate(Instant.now());
            rentalDao.insert(rentalMapper.toEntity(rentalDto));
    }

    @Override
    public void update(RentalDto rentalDto) {
            rentalDto.setLastUpdate(Instant.now());
            rentalDto.setRentalDate(Instant.now());
            rentalDao.update(rentalMapper.toEntity(rentalDto));
    }

    @Override
    public void delete(RentalDto rentalDto) {
            rentalDao.delete(rentalDao.getById(rentalDto.getId()));
    }
}
