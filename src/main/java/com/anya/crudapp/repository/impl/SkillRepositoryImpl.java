package com.anya.crudapp.repository.impl;

import com.anya.crudapp.model.Skill;
import com.anya.crudapp.repository.inter.SkillRepository;
import com.anya.crudapp.util.HibernateSessionFactoryUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class SkillRepositoryImpl implements SkillRepository {
    @Override
    public Skill getById(Integer id) {
        Skill skill;
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            skill = session.get(Skill.class, id);
            transaction.commit();
        }
        return skill;
    }

    @Override
    public Skill addToDatabase(Skill skill) {
        Skill savedSkill;
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.persist(skill);
           savedSkill = session.find(Skill.class, skill.getId());
            transaction.commit();
        }
        return savedSkill;
    }

    @Override
    public void delete(Skill object) {
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.remove(object);
            transaction.commit();
        }

    }

    @Override
    public Skill updateObject(Skill skill) {
        Skill updatedSkill;
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            updatedSkill = session.merge(skill);
            transaction.commit();

        }
        return updatedSkill;
    }
}
