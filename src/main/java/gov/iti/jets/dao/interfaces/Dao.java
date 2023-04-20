package gov.iti.jets.dao.interfaces;

import java.util.List;

public interface Dao<K,E> {

    List<E>getAll();

    E getById(K id);

    void insert(E entity);

    void update(E entity);

    void delete(E entity);
}
