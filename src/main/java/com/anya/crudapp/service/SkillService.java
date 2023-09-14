package com.anya.crudapp.service;

import com.anya.crudapp.model.Skill;
import com.anya.crudapp.repository.impl.SkillRepositoryImpl;
import com.anya.crudapp.repository.inter.SkillRepository;

public class SkillService {
    SkillRepository skillRepository = new SkillRepositoryImpl();

    public Skill getSkillById(Integer id) {
        return skillRepository.getById(id);
    }

    public Skill saveSkill(Skill skill) {
        return skillRepository.addToDatabase(skill);
    }

    public void deleteSkill(Skill skill) {
        skillRepository.delete(skill);
    }

    public Skill updateSkill(Skill skill) {
        return skillRepository.updateObject(skill);
    }
}
