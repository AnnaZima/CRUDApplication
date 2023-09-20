package com.anya.crudapp.util;
import com.anya.crudapp.model.Developer;
import com.anya.crudapp.model.Skill;
import com.anya.crudapp.model.Specialty;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import java.util.Arrays;

public class HibernateSessionFactoryUtil {
    private static SessionFactory sessionFactory;

    private HibernateSessionFactoryUtil() {

    }

    public static SessionFactory getSessionFactory() {
        if(sessionFactory == null) {
//            try{
//
//                Configuration configure = new Configuration().configure("hibernate.cfg.xml");
//
//                sessionFactory = configure
//                        .addAnnotatedClass(Developer.class)
//                        .addAnnotatedClass(Skill.class)
//                        .addAnnotatedClass(Specialty.class).buildSessionFactory();
//            } catch (Exception e) {
//                System.out.println(Arrays.toString(e.getStackTrace()));
//            }
            try {
                StandardServiceRegistry standardRegistry =
                        new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
                Metadata metaData =
                        new MetadataSources(standardRegistry)
                                .addAnnotatedClass(Developer.class)
                                .addAnnotatedClass(Skill.class)
                                .addAnnotatedClass(Specialty.class)
                                .getMetadataBuilder().build();
                sessionFactory = metaData.getSessionFactoryBuilder().build();
            } catch (Throwable th) {
                System.err.println("Enitial SessionFactory creation failed" + th);
                throw new ExceptionInInitializerError(th);
            }
        }
        return sessionFactory;
    }
}
