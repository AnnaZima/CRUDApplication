package com.anya.crudapp.controller;

import com.anya.crudapp.model.Specialty;
import com.anya.crudapp.model.Status;
import com.anya.crudapp.service.SpecialtyService;

import java.util.List;

public class SpecialtyController {
    SpecialtyService specialtyService = new SpecialtyService();

    public Specialty getSpecialtyById(Integer id) {
        return specialtyService.getSpecialtyById(id);
    }

    public  Specialty saveSpecialty(String name) {
        Specialty specialty = new Specialty();
        specialty.setName(name);
        specialty.setStatus(Status.ACTIVE);
        return specialtyService.saveSpecialty(specialty);
    }

    public void deleteSpecialty(Integer id) {
        specialtyService.deleteSpecialty(id);
    }

    public  Specialty updateSpecialty(Integer id, String name) {
        Specialty specialty = new Specialty(id, name, Status.ACTIVE);
       return specialtyService.updateSpecialty(specialty);
    }

    public List<Specialty> getAll() {
        return specialtyService.getAll();
    }
}
