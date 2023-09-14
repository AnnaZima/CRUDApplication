package com.anya.crudapp.controller;

import com.anya.crudapp.model.Skill;
import com.anya.crudapp.service.SkillService;

public class SkillController {
    SkillService skillService = new SkillService();

    public Skill getSkillById(Integer id) {
        return skillService.getSkillById(id);
    }

    public Skill saveSkill(String name) {
        Skill skill = new Skill();
        skill.setName(name);
        return skillService.saveSkill(skill);
    }

    public void deleteSkill(Integer id, String name) {
        Skill skill = new Skill(id, name);
        skillService.deleteSkill(skill);
    }

    public Skill updateSkill(Integer id, String name) {
        Skill skill = new Skill();
        skill.setName(name);
        skill.setId(id);
        return skillService.updateSkill(skill);
    }

}
