package com.anya.crudapp.repository.impl;

import com.anya.crudapp.model.Developer;
import com.anya.crudapp.model.Status;
import com.anya.crudapp.repository.DeveloperRepository;
import com.anya.crudapp.repository.GenericRepository;
import com.anya.crudapp.util.HibernateSessionFactoryUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class DeveloperRepositoryImpl implements DeveloperRepository {
    @Override
    public Developer getById(Integer id) {
        Developer developer;
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            developer = session.get(Developer.class, id);
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
    public void delete(Integer id) {
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            Developer developer = session.find(Developer.class, id);
            developer.setStatus(Status.DELETE);
            session.merge(developer);
            transaction.commit();
        }

    }

    @Override
    public Developer updateObject(Developer developer) {
        Developer updatedDeveloper;
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            updatedDeveloper = (Developer)session.merge(developer);
            transaction.commit();
        }
        return updatedDeveloper;
    }

    @Override
    public List<Developer> getAll() {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        List<Developer> from_developer =  (List<Developer>)session.createQuery("From Developer").getResultList();
        session.close();
        return from_developer;
    }
}
