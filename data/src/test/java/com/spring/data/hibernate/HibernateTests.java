package com.spring.data.hibernate;

import com.spring.data.entity.Pet;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.jupiter.api.Test;

import java.util.Date;

public class HibernateTests {

    @Test
    public void testCreateEntity() {
//        Session session = HibernateConfig.getSessionFactory().openSession();
//        Transaction tx = session.beginTransaction();
//
//        Pet pet = new Pet();
//        pet.setId(1L);
//        pet.setName("kedicik");
//        session.persist(pet);
//        tx.commit();
//        session.close();
    }

    private SessionFactory sessionFactory;

    @Test
    public void testFieldLevelAccess() {

//        Pet pet = new Pet("kedicik", new Date());
//        pet.setId(1L);
//
//        Session session = HibernateUtil.getSessionFactory().openSession();
//        Transaction transaction = session.beginTransaction();
//        session.save(pet);
//        transaction.commit();
//        session.close();


//        session = sessionFactory.openSession();
//        Pet pet1 = session.get(Pet.class, 1L);
//        System.out.println(pet1);
    }
}
