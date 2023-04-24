package gov.iti.jets.service.implem;

import gov.iti.jets.dao.imple.CategoryDao;
import gov.iti.jets.entity.Category;
import gov.iti.jets.entity.FilmCategory;
import gov.iti.jets.service.dto.CategoryDto;
import gov.iti.jets.service.dto.FilmDto;
import gov.iti.jets.service.interfaces.CategoryServic;
import gov.iti.jets.service.mapper.CategoryMapper;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class CategoryImplem implements CategoryServic {

    public static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("rsa");
    public static EntityManager entityManager = entityManagerFactory.createEntityManager();

    CategoryDao categoryDao = new CategoryDao(entityManager);
    CategoryMapper categoryMapper = CategoryMapper.INSTANCE;
    @Override
    public List<CategoryDto> getAll() {
        List<Category> listOfCategory = categoryDao.getAll();
        List<CategoryDto> listOfCategoryDto = new ArrayList<>();
        for (Category category : listOfCategory){
            listOfCategoryDto.add(categoryMapper.toDto(category));
        }
        return listOfCategoryDto;
    }

    @Override
    public CategoryDto getById(Integer id) {
        return categoryMapper.toDto(categoryDao.getById(id));
    }

    @Override
    public void insert(CategoryDto categoryDto) {
        categoryDto.setLastUpdate(Instant.now());
        categoryDao.insert(categoryMapper.toEntity(categoryDto));
    }

    @Override
    public void update(CategoryDto categoryDto) {
        categoryDto.setLastUpdate(Instant.now());
        categoryDao.insert(categoryMapper.toEntity(categoryDto));
    }

    @Override
    public void delete(CategoryDto categoryDto) {
        categoryDao.delete(categoryDao.getById(Integer.valueOf(categoryDto.getId())));
    }


}
