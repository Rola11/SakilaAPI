package gov.iti.jets.service.implem;

import gov.iti.jets.dao.imple.FilmTextDao;
import gov.iti.jets.dao.imple.InventoryDao;
import gov.iti.jets.entity.Inventory;
import gov.iti.jets.service.dto.InventoryDto;
import gov.iti.jets.service.interfaces.InventoryServic;
import gov.iti.jets.service.mapper.FilmTextMapper;
import gov.iti.jets.service.mapper.InventoryMapper;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class InventoryImplem implements InventoryServic {
    public static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("rsa");
    public static EntityManager entityManager = entityManagerFactory.createEntityManager();
    InventoryDao inventoryDao = new InventoryDao(entityManager);
    InventoryMapper inventoryMapper = InventoryMapper.INSTANCE;

    @Override
    public List<InventoryDto> getAll() {
        List<Inventory> listOfInventory = inventoryDao.getAll();
        List<InventoryDto> listOfInventoryDto = new ArrayList<>();
        for (Inventory inventory : listOfInventory) {
            listOfInventoryDto.add(inventoryMapper.toDto(inventory));
        }
        return listOfInventoryDto;
    }

    @Override
    public InventoryDto getById(Integer id) {
        return inventoryMapper.toDto(inventoryDao.getById(id));
    }

    @Override
    public void insert(InventoryDto inventoryDto) {
            inventoryDto.setLastUpdate(Instant.now());
            inventoryDao.insert(inventoryMapper.toEntity(inventoryDto));
    }

    @Override
    public void update(InventoryDto inventoryDto) {
        inventoryDto.setLastUpdate(Instant.now());
        inventoryDao.update(inventoryMapper.toEntity(inventoryDto));

    }

    @Override
    public void delete(InventoryDto inventoryDto) {
        inventoryDao.delete(inventoryDao.getById(inventoryDto.getId()));
    }
}
