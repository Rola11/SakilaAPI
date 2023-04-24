package gov.iti.jets.service.implem;

import gov.iti.jets.dao.imple.StaffDao;
import gov.iti.jets.dao.imple.StoreDao;
import gov.iti.jets.entity.Store;
import gov.iti.jets.service.dto.StoreDto;
import gov.iti.jets.service.interfaces.StoreServic;
import gov.iti.jets.service.mapper.StaffMapper;
import gov.iti.jets.service.mapper.StoreMapper;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class StoreImplem implements StoreServic {
    public static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("rsa");
    public static EntityManager entityManager = entityManagerFactory.createEntityManager();
    StoreDao storeDao = new StoreDao(entityManager);
    StoreMapper storeMapper = StoreMapper.INSTANCE;

    @Override
    public List<StoreDto> getAll() {
        List<Store>listOfStore = storeDao.getAll();
        List<StoreDto>listOfStoreDto = new ArrayList<>();
        for(Store store: listOfStore){
            listOfStoreDto.add(storeMapper.toDto(store));
        }
        return listOfStoreDto;
    }

    @Override
    public StoreDto getById(Integer id) {
        return storeMapper.toDto(storeDao.getById(id));
    }

    @Override
    public void insert(StoreDto storeDto) {
        storeDto.setLastUpdate(Instant.now());
        storeDao.insert(storeMapper.toEntity(storeDto));
    }

    @Override
    public void update(StoreDto storeDto) {
            storeDto.setLastUpdate(Instant.now());
            storeDao.update(storeMapper.toEntity(storeDto));
    }

    @Override
    public void delete(StoreDto storeDto) {
            storeDao.delete(storeDao.getById(Integer.valueOf(storeDto.getId())));
    }
}
