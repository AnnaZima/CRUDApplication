package com.anya.crudapp.repository.impl;

import com.anya.crudapp.model.Skill;
import com.anya.crudapp.model.Status;
import com.anya.crudapp.repository.GenericRepository;
import com.anya.crudapp.repository.SkillRepository;
import com.anya.crudapp.util.HibernateSessionFactoryUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class SkillRepositoryImpl implements SkillRepository {
    @Override
    public Skill getById(Integer id) {
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            return session.get(Skill.class, id);
        }
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
    public void delete(Integer id) {
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            Skill skill = session.find(Skill.class, id);
            skill.setStatus(Status.DELETE);
            session.merge(skill);
            transaction.commit();
        }

    }

    @Override
    public Skill updateObject(Skill skill) {
        Skill updatedSkill;
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            updatedSkill = (Skill) session.merge(skill);
            transaction.commit();

        }
        return updatedSkill;
    }

    @Override
    public List<Skill> getAll() {
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            List<Skill> from_skills = (List<Skill>) session.createQuery("From Skill").list();
            return from_skills;
        }
    }
}
