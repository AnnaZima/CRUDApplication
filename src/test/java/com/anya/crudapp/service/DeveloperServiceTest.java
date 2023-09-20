package com.anya.crudapp.service;


import com.anya.crudapp.model.Developer;
import com.anya.crudapp.model.Skill;
import com.anya.crudapp.model.Specialty;
import com.anya.crudapp.model.Status;
import com.anya.crudapp.repository.DeveloperRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class DeveloperServiceTest {

    @Mock
    DeveloperRepository developerRepository;
    @InjectMocks
    DeveloperService developerService;


    private Developer getDeveloper() {
        return new Developer(1, "Ivan", "Ivanov", getSkills(), getSpecialty(), Status.ACTIVE);
    }

    private Specialty getSpecialty() {
        return new Specialty(2, "java", Status.ACTIVE);
    }

    private List<Skill> getSkills() {
        List<Skill> skills = new ArrayList<>();
        Skill skillFirst = new Skill();
        Skill skillSecond = new Skill(4, "jdbc", null, Status.ACTIVE);
        skills.add(skillFirst);
        skills.add(skillSecond);
        return skills;
    }

    @Test
    void getByID() {
        when(developerRepository.getById(1)).thenReturn(getDeveloper());
        Developer developer = developerService.getDeveloperById(1);
        Assertions.assertEquals("Ivan", developer.getFirstname());

    }

    @Test
    void updateDeveloper() {
        when(developerRepository.updateObject(any(Developer.class))).thenReturn(getDeveloper());
        Developer updated = developerService.updateDeveloper(new Developer(1, "Ivan", "Ivanov", getSkills(), getSpecialty(), Status.ACTIVE));
        Assertions.assertEquals("Ivan", updated.getFirstname());
        Assertions.assertEquals("java", updated.getSpecialty().getName());
    }

    @Test
    void saveDeveloper() {
        when(developerRepository.addToDatabase(any(Developer.class))).thenReturn(getDeveloper());
        Developer developer = developerService.saveDeveloper(new Developer("Ivan", "Ivanov", getSkills(), getSpecialty(), Status.ACTIVE));
        Assertions.assertEquals("Ivanov", developer.getLastname());
    }

    @Test
    void deleteDeveloper() {
        DeveloperService developerService1 = Mockito.mock(DeveloperService.class);
        doNothing().when(developerService1).deleteDeveloper(1);
    }


}
