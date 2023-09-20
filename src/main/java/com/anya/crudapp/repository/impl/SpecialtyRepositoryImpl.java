package com.anya.crudapp.repository.impl;

import com.anya.crudapp.model.Skill;
import com.anya.crudapp.model.Specialty;
import com.anya.crudapp.model.Status;
import com.anya.crudapp.repository.GenericRepository;
import com.anya.crudapp.repository.SpecialtyRepository;
import com.anya.crudapp.util.HibernateSessionFactoryUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class SpecialtyRepositoryImpl implements SpecialtyRepository {

    @Override
    public Specialty getById(Integer id) {
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            return session.get(Specialty.class, id);
        }
    }

    @Override
    public Specialty addToDatabase(Specialty specialty) {
        Specialty savedSpecialty;
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.persist(specialty);
            savedSpecialty = session.find(Specialty.class, specialty.getId());
            transaction.commit();
        }
        return savedSpecialty;
    }

    @Override
    public void delete(Integer id) {
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            Specialty specialty = session.find(Specialty.class, id);
            specialty.setStatus(Status.DELETE);
            session.merge(specialty);
            transaction.commit();
        }

    }

    @Override
    public Specialty updateObject(Specialty specialty) {
        Specialty updatedSpecialty;
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            updatedSpecialty = (Specialty) session.merge(specialty);
            transaction.commit();
        }
        return updatedSpecialty;

    }

    @Override
    public List<Specialty> getAll() {
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            List<Specialty> from_specialty = (List<Specialty>) session.createQuery("From Specialty").list();
            return from_specialty;
        }
    }
}
