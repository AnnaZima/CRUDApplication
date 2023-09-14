package com.anya.crudapp.repository.inter;

public interface GenericRepository <T, ID>{
    T getById(ID id);
    T addToDatabase(T object);
    void delete(T object);
    T updateObject(T object);


}
