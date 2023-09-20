package com.anya.crudapp.repository;

import java.util.List;

public interface GenericRepository <T, ID>{
    T getById(ID id);
    T addToDatabase(T object);
    void delete(ID id);
    T updateObject(T object);
    List<T> getAll();



}
