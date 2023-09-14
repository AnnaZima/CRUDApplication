package com.anya.crudapp.service;

import com.anya.crudapp.model.Developer;
import com.anya.crudapp.repository.impl.DeveloperRepositoryImpl;
import com.anya.crudapp.repository.inter.DeveloperRepository;

public class DeveloperService {
    DeveloperRepository developerRepository = new DeveloperRepositoryImpl();

    public Developer getDeveloperById(Integer id) {
        return developerRepository.getById(id);
    }

    public Developer saveDeveloper (Developer developer) {
        return developerRepository.addToDatabase(developer);
    }
    public void deleteDeveloper(Developer developer) {
       developerRepository.delete(developer);
    }

    public  Developer updateDeveloper(Developer developer) {
      return developerRepository.updateObject(developer);
    }
}
