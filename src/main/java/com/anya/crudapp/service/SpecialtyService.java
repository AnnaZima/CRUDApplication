package com.anya.crudapp.service;

import com.anya.crudapp.model.Specialty;
import com.anya.crudapp.repository.SpecialtyRepository;
import com.anya.crudapp.repository.impl.SpecialtyRepositoryImpl;

import java.util.List;

public class SpecialtyService {

    private final SpecialtyRepository specialtyRepository;

    public SpecialtyService(SpecialtyRepository specialtyRepository) {
        this.specialtyRepository = specialtyRepository;
    }

    public SpecialtyService() {
        specialtyRepository = new SpecialtyRepositoryImpl();
    }

    public Specialty getSpecialtyById(Integer id) {
        return specialtyRepository.getById(id);
    }

    public  Specialty saveSpecialty(Specialty specialty) {
       return specialtyRepository.addToDatabase(specialty);
    }

    public void deleteSpecialty(Integer id) {
        specialtyRepository.delete(id);
    }

    public  Specialty updateSpecialty(Specialty specialty) {
       return specialtyRepository.updateObject(specialty);
    }

    public List<Specialty> getAll() {
        return  specialtyRepository.getAll();
    }
}
