package com.anya.crudapp.service;

import com.anya.crudapp.model.Skill;
import com.anya.crudapp.model.Status;
import com.anya.crudapp.repository.SkillRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class SkillServiceTest {

    @Mock
    SkillRepository skillRepository;
    @InjectMocks
    SkillService skillService;

    private Skill getSkill() {
        return new Skill(1, "hibernate", null, Status.ACTIVE);
    }


    @Test
    void getById() {
     when(skillRepository.getById(any(Integer.class))).thenReturn(getSkill());
     Skill skill = skillService.getSkillById(1);
        Assertions.assertEquals("hibernate", skill.getName());
    }

    @Test
    void updateSkill() {
        when(skillRepository.updateObject(any(Skill.class))).thenReturn(getSkill());
        Skill skill = skillService.updateSkill(new Skill());
        Assertions.assertEquals("hibernate", skill.getName());
    }

    @Test
    void savaSkill() {
        when(skillRepository.addToDatabase(any(Skill.class))).thenReturn(getSkill());
        Skill skill = skillService.saveSkill(new Skill());
        Assertions.assertEquals("hibernate", skill.getName());
    }

    @Test
    void deleteSkill() {
        SkillService skillService1 = Mockito.mock(SkillService.class);
        doNothing().when(skillService1).deleteSkill(1);
    }

}
