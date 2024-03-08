package com.spring.data.hibernate;

import com.spring.data.entity.City;
import com.spring.data.entity.Pet;
import com.spring.data.entity.PetType;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.jupiter.api.Test;

import static hibernate.HibernateUtil.getSessionFactory;

public class HibernateTests {

    private SessionFactory sessionFactory;

    public HibernateTests() {
        sessionFactory = hibernate.HibernateUtil.getSessionFactory();
    }

    @Test
    public void testGet(){
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        City pet = session.get(City.class, 1L);
        System.out.println("--- pet loaded ---");
        System.out.println(pet.getName());
        System.out.println(pet.getClass());
    }

}
