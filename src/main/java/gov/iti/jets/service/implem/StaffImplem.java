package gov.iti.jets.service.implem;

import gov.iti.jets.dao.imple.RentalDao;
import gov.iti.jets.dao.imple.StaffDao;
import gov.iti.jets.entity.Staff;
import gov.iti.jets.service.dto.StaffDto;
import gov.iti.jets.service.interfaces.StaffServic;
import gov.iti.jets.service.mapper.RentalMapper;
import gov.iti.jets.service.mapper.StaffMapper;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class StaffImplem implements StaffServic {
    public static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("rsa");
    public static EntityManager entityManager = entityManagerFactory.createEntityManager();
    StaffDao staffDao = new StaffDao(entityManager);
    StaffMapper staffMapper = StaffMapper.INSTANCE;

    @Override
    public List<StaffDto> getAll() {
        List<Staff> listOfStaff = staffDao.getAll();
        List<StaffDto>listOfStaffDto = new ArrayList<>();
        for(Staff staff : listOfStaff){
            listOfStaffDto.add(staffMapper.toDto(staff));
        }
        return listOfStaffDto;
    }

    @Override
    public StaffDto getById(Integer id) {
        return staffMapper.toDto(staffDao.getById(id));
    }

    @Override
    public void insert(StaffDto staffDto) {
            staffDto.setLastUpdate(Instant.now());
            staffDao.insert(staffMapper.toEntity(staffDto));
    }

    @Override
    public void update(StaffDto staffDto) {
            staffDto.setLastUpdate(Instant.now());
            staffDao.update(staffMapper.toEntity(staffDto));
    }

    @Override
    public void delete(StaffDto staffDto) {
            staffDao.delete(staffDao.getById(Integer.valueOf(staffDto.getId())));
    }
}
