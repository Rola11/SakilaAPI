package gov.iti.jets.service.implem;

import gov.iti.jets.dao.imple.CustomerDao;
import gov.iti.jets.entity.Customer;
import gov.iti.jets.service.dto.CustomerDto;
import gov.iti.jets.service.interfaces.CustomerServic;
import gov.iti.jets.service.mapper.CustomerMapper;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class CustomerImplem implements CustomerServic {

    public static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("rsa");
    public static EntityManager entityManager = entityManagerFactory.createEntityManager();
    CustomerDao customerDao = new CustomerDao(entityManager);
    CustomerMapper customerMapper = CustomerMapper.INSTANCE;
    @Override
    public List<CustomerDto> getAll() {
         List<Customer> listOfCustomer = customerDao.getAll();
         List<CustomerDto> listOfCustomerDto = new ArrayList<>();
         for (Customer customer : listOfCustomer){
             listOfCustomerDto.add(customerMapper.toDto(customer));
         }
        return listOfCustomerDto;
    }

    @Override
    public CustomerDto getById(Integer id) {
        return customerMapper.toDto(customerDao.getById(id));
    }

    @Override
    public void insert(CustomerDto customerDto) {
            customerDto.setLastUpdate(Instant.now());
            customerDto.setCreateDate(Instant.now());
            customerDao.insert(customerMapper.toEntity(customerDto));
    }

    @Override
    public void update(CustomerDto customerDto) {
        customerDto.setLastUpdate(Instant.now());
        customerDto.setCreateDate(Instant.now());
        customerDao.update(customerMapper.toEntity(customerDto));
    }

    @Override
    public void delete(CustomerDto customerDto) {
        customerDao.delete(customerDao.getById(customerDto.getId()));
    }
}
