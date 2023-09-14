package com.anya.crudapp.controller;

import com.anya.crudapp.model.Specialty;
import com.anya.crudapp.service.SpecialtyService;

public class SpecialtyController {
    SpecialtyService specialtyService = new SpecialtyService();

    public Specialty getSpecialtyById(Integer id) {
        return specialtyService.getSpecialtyById(id);
    }

    public  Specialty saveSpecialty(String name) {
        Specialty specialty = new Specialty();
        specialty.setName(name);
        return specialtyService.saveSpecialty(specialty);
    }

    public void deleteSpecialty(Integer id, String name) {
        Specialty specialty = new Specialty(id, name);
        specialtyService.deleteSpecialty(specialty);
    }

    public  Specialty updateSpecialty(Integer id, String name) {
        Specialty specialty = new Specialty(id, name);
       return specialtyService.updateSpecialty(specialty);
    }

}
