package com.anya.crudapp.repository.impl;

import com.anya.crudapp.model.Specialty;
import com.anya.crudapp.repository.inter.SpecialtyRepository;
import com.anya.crudapp.util.HibernateSessionFactoryUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class SpecialtyRepositoryImpl implements SpecialtyRepository {

    @Override
    public Specialty getById(Integer id) {
        Specialty specialty;
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            specialty = session.get(Specialty.class, id);
        }
        return specialty;
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
    public void delete(Specialty object) {
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.remove(object);
            transaction.commit();
        }

    }

    @Override
    public Specialty updateObject(Specialty specialty) {
        Specialty updatedSpecialty;
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            updatedSpecialty = session.merge(specialty);
            transaction.commit();
        }
        return updatedSpecialty;

    }
}
