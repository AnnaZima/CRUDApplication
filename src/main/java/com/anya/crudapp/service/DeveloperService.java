package com.anya.crudapp.service;

import com.anya.crudapp.model.Developer;
import com.anya.crudapp.repository.DeveloperRepository;
import com.anya.crudapp.repository.impl.DeveloperRepositoryImpl;

import java.util.List;

public class DeveloperService {
    private final DeveloperRepository developerRepository;


    public DeveloperService() {
        developerRepository = new DeveloperRepositoryImpl();
    }

    public DeveloperService(DeveloperRepository developerRepository) {
        this.developerRepository = developerRepository;
    }

    public Developer getDeveloperById(Integer id) {
        return developerRepository.getById(id);
    }

    public Developer saveDeveloper (Developer developer) {
        return developerRepository.addToDatabase(developer);
    }


    public void deleteDeveloper(Integer id) {
       developerRepository.delete(id);
    }

    public  Developer updateDeveloper(Developer developer) {
      return developerRepository.updateObject(developer);
    }

    public List<Developer> getAll() {
        return developerRepository.getAll();
    }
}


