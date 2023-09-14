package com.anya.crudapp.repository.impl;

import com.anya.crudapp.model.Developer;
import com.anya.crudapp.repository.inter.DeveloperRepository;
import com.anya.crudapp.util.HibernateSessionFactoryUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class DeveloperRepositoryImpl implements DeveloperRepository {
    @Override
    public Developer getById(Integer id) {
        Developer developer;
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            developer = session.get(Developer.class, id);
            transaction.commit();
        }
        return developer;
    }

    @Override
    public Developer addToDatabase(Developer developer) {
        Developer savedDeveloper;
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.persist(developer);
            savedDeveloper = session.find(Developer.class, developer.getId());
            transaction.commit();
        }
        return savedDeveloper;

    }

    @Override
    public void delete(Developer developer) {
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.remove(developer);
            transaction.commit();
        }

    }

    @Override
    public Developer updateObject(Developer developer) {
        Developer updatedDeveloper;
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            updatedDeveloper = session.merge(developer);
            transaction.commit();
        }
        return updatedDeveloper;
    }
}
