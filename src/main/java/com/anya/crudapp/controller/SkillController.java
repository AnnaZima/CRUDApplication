package com.anya.crudapp.controller;

import com.anya.crudapp.model.Skill;
import com.anya.crudapp.model.Status;
import com.anya.crudapp.service.SkillService;

import java.util.List;

public class SkillController {
    SkillService skillService = new SkillService();

    public Skill getSkillById(Integer id) {
        return skillService.getSkillById(id);
    }

    public Skill saveSkill(String name) {
        Skill skill = new Skill();
        skill.setName(name);
        skill.setStatus(Status.ACTIVE);
        return skillService.saveSkill(skill);
    }

    public void deleteSkill(Integer id) {
        skillService.deleteSkill(id);
    }

    public Skill updateSkill(Integer id, String name) {
        Skill skill = new Skill();
        skill.setName(name);
        skill.setId(id);
        skill.setStatus(Status.ACTIVE);
        return skillService.updateSkill(skill);
    }

    public List<Skill> getAll() {
       return skillService.getAll();
    }
}
