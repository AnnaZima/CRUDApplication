package com.anya.crudapp.controller;

import com.anya.crudapp.model.Developer;
import com.anya.crudapp.model.Skill;
import com.anya.crudapp.model.Specialty;
import com.anya.crudapp.service.DeveloperService;

import java.util.Arrays;
import java.util.List;

public class DeveloperController {
    DeveloperService developerController = new DeveloperService();
    SkillController skillController = new SkillController();
    SpecialtyController specialtyController = new SpecialtyController();

    private Developer createDeveloperWithId(int id, String name, String surname, String skills, String nameSpecialty) {
        List<Skill> skillList = Arrays.stream(skills.split(" "))
                .map(s -> skillController.saveSkill(s)).toList();
        Specialty specialty = specialtyController.saveSpecialty(nameSpecialty);
        Developer developer = new Developer();
        developer.setId(id);
        developer.setFirstname(name);
        developer.setLastname(surname);
        developer.setSkills(skillList);
        developer.setSpecialty(specialty);
        return developer;
    }

    public Developer getDeveloperById(Integer id) {
        return developerController.getDeveloperById(id);
    }

    public Developer saveDeveloper (String name, String surname, String skills, String nameSpecialty) {
        List<Skill> skillList = Arrays.stream(skills.split(" "))
                .map(s -> skillController.saveSkill(s)).toList();
        Specialty specialty = specialtyController.saveSpecialty(nameSpecialty);
        Developer developer = new Developer();
        developer.setFirstname(name);
        developer.setLastname(surname);
        developer.setSkills(skillList);
        developer.setSpecialty(specialty);
        return developerController.saveDeveloper(developer);
    }
//как правильно удалить большой объект?
    public void deleteDeveloper(int id, String name, String surname, String skills, String nameSpecialty) {
        Developer developer = createDeveloperWithId(id, name, surname, skills, nameSpecialty);
        developerController.deleteDeveloper(developer);
    }

    public  Developer updateDeveloper(int id, String name, String surname, String skills, String nameSpecialty) {
       Developer developer = createDeveloperWithId(id, name, surname, skills, nameSpecialty);
        return developerController.updateDeveloper(developer);
    }
}
