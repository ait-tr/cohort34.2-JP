package de.ait.repositories;

import java.util.List;

public interface CrudRepository<T> { // create read update delete
   void  save(T element);
    List<T> findAll();
    T findByID(Long id);

    void update(T element);
    void  deleteByID(Long id);
}
