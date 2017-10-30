package edu.mum.cs.cs544.examples;

import java.time.LocalDate;
import java.time.Month;
import java.util.Date;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class Application {

    private static final SessionFactory sessionFactory;
    private static final ServiceRegistry serviceRegistry;

    static {
        Configuration configuration = new Configuration();
        configuration.configure();
        
        serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();   
        sessionFactory = configuration.buildSessionFactory(serviceRegistry);
    }

    public static void main(String[] args) {
        Session session = null;
        Transaction tx = null;

        try {
            session = sessionFactory.openSession();
            tx = session.beginTransaction();
            
            Person john = new Person("John", "Doe");
            
            Pet cat = new Pet("Meow", new Date());
            Pet dog = new Pet("Max", new Date());
            
            john.addPet(cat);
            john.addPet(dog);
            
            Toy toy1 = new Ball("Ball", 10);
            Toy toy2 = new StuffedAnimal("Beanie Boo", "Cat");
            Toy toy3 = new Ball("Ball", 15);
            Toy toy4 = new StuffedAnimal("Beanie Boo", "Dog");
            
            cat.addToy(toy1);
            cat.addToy(toy2);

            dog.addToy(toy3);
            dog.addToy(toy4);
            
            session.persist(john);
            
            session.persist(cat);
            session.persist(dog);

            session.persist(toy1);
            session.persist(toy2);
            session.persist(toy3);
            session.persist(toy4);

            // Query
            Query query = session.createQuery("from Person");
            @SuppressWarnings("unchecked")
			List<Person> persons = query.list();
            for (Person person : persons) {
                System.out.println(person);
            }
            
            Query query1 = session.createQuery("Select p from Person p join p.pets pet where pet.name='Meow'");
            @SuppressWarnings("unchecked")
			List<Person> result1 = query1.list();
            for (Person person : result1) {
                System.out.println(person);
            }
            
            Query query2 = session.createQuery("Select p from Pet p join p.toys t where p.person.name='John' and t.description='Ball'");
            @SuppressWarnings("unchecked")
			List<Person> result2 = query2.list();
            for (Person person : result1) {
                System.out.println(person);
            }
            
            tx.commit();

        } catch (HibernateException e) {
            if (tx != null) {
                System.err.println("Rolling back: " + e.getMessage());
                tx.rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }

        // Close the SessionFactory (not mandatory)
        sessionFactory.close();
        System.exit(0);
    }
}
