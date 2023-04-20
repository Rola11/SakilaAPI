package gov.iti.jets.dao.imple;

import gov.iti.jets.dao.interfaces.Dao;
import gov.iti.jets.entity.Actor;

import jakarta.persistence.EntityManager;
import java.util.List;

public class GenericDao<K,E> implements Dao<K,E> {

    private final EntityManager entityManager;
    private final Class<E> entityClass;
   public GenericDao(EntityManager entityManager,Class<E>entityClass){

        this.entityClass = entityClass;
        this.entityManager = entityManager;
    }

    @Override
    public List<E> getAll() {
        return entityManager.createQuery("select e from "+entityClass.getSimpleName()+" e", entityClass).getResultList();
    }

    @Override
    public E getById(K id) {
        return entityManager.find(entityClass,id);
    }

    @Override
    public void insert(E entity) {

        if(!entityManager.getTransaction().isActive()){
            entityManager.getTransaction().begin();
        }
        entityManager.persist(entity);
        entityManager.getTransaction().commit();
    }

    @Override
    public void update(E entity) {

        if(!entityManager.getTransaction().isActive()){
            entityManager.getTransaction().begin();
        }
        entityManager.merge(entity);
        entityManager.getTransaction().commit();
    }

    @Override
    public void delete(E entity) {

        if(!entityManager.getTransaction().isActive()){
            entityManager.getTransaction().begin();
        }
        entityManager.remove(entity);
        entityManager.getTransaction().commit();
    }
}
