package com.anya.crudapp.service;

import com.anya.crudapp.model.Skill;
import com.anya.crudapp.repository.SkillRepository;
import com.anya.crudapp.repository.impl.SkillRepositoryImpl;

import java.util.List;

public class SkillService {
  private final SkillRepository skillRepository;

  public SkillService(){
      skillRepository = new SkillRepositoryImpl();
  }

  public SkillService(SkillRepository skillRepository) {
      this.skillRepository = skillRepository;
  }





    public Skill getSkillById(Integer id) {
        return skillRepository.getById(id);
    }

    public Skill saveSkill(Skill skill) {
        return skillRepository.addToDatabase(skill);
    }

    public void deleteSkill(Integer id) {
        skillRepository.delete(id);
    }

    public Skill updateSkill(Skill skill) {
        return skillRepository.updateObject(skill);
    }

    public List<Skill> getAll() {
      return skillRepository.getAll();
    }
}
