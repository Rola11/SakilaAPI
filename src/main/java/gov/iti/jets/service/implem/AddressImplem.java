package gov.iti.jets.service.implem;

import gov.iti.jets.dao.imple.AddressDao;
import gov.iti.jets.service.dto.AddressDto;
import gov.iti.jets.service.interfaces.AddressServic;
import gov.iti.jets.service.mapper.AddressMapper;
import gov.iti.jets.entity.Address;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class AddressImplem implements AddressServic {

    public static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("rsa");
    public static EntityManager entityManager = entityManagerFactory.createEntityManager();

    AddressDao addressDao = new AddressDao(entityManager);
    AddressMapper addressMapper = AddressMapper.INSTANCE;
    @Override
    public List<AddressDto> getAll() {
        List<Address> listOfAddress = addressDao.getAll();
        List<AddressDto> listOfAddressDto = new ArrayList<>();
        for (Address address : listOfAddress){
            listOfAddressDto.add(addressMapper.toDto(address));
        }
        return listOfAddressDto;
    }

    @Override
    public AddressDto getById(Integer id) {
        return addressMapper.toDto(addressDao.getById(id));
    }

    @Override
    public void insert(AddressDto addressDto) {
        addressDto.setLastUpdate(Instant.now());
        addressDao.insert(addressMapper.toEntity(addressDto));
    }

    @Override
    public void update(AddressDto addressDto) {
        addressDto.setLastUpdate(Instant.now());
        addressDao.update(addressMapper.toEntity(addressDto));
    }

    @Override
    public void delete(AddressDto addressDto) {
        addressDao.delete(addressDao.getById(addressDto.getId()));
    }
}
