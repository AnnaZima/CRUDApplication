package com.anya.crudapp.service;

import com.anya.crudapp.model.Specialty;
import com.anya.crudapp.repository.impl.SpecialtyRepositoryImpl;
import com.anya.crudapp.repository.inter.SpecialtyRepository;

public class SpecialtyService {
    SpecialtyRepository specialtyRepository = new SpecialtyRepositoryImpl();

    public Specialty getSpecialtyById(Integer id) {
        return specialtyRepository.getById(id);
    }

    public  Specialty saveSpecialty(Specialty specialty) {
       return specialtyRepository.addToDatabase(specialty);
    }

    public void deleteSpecialty(Specialty specialty) {
        specialtyRepository.delete(specialty);
    }

    public  Specialty updateSpecialty(Specialty specialty) {
       return specialtyRepository.updateObject(specialty);
    }
}
