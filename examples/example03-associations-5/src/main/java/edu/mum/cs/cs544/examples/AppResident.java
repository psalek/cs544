package edu.mum.cs.cs544.examples;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class AppResident {

    private static final SessionFactory sessionFactory;
    private static final ServiceRegistry serviceRegistry;

    static {
        Configuration configuration = new Configuration();
        configuration.configure();
        
        serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();   
        sessionFactory = configuration.buildSessionFactory(serviceRegistry);
    }

    public static void main(String[] args) {
        // Hibernate placeholders
        Session session = null;
        Transaction tx = null;

        try {
            session = sessionFactory.openSession();
            tx = session.beginTransaction();
            
            Resident resident1 = new Resident("John", "Doe");
            session.persist(resident1);

            Resident resident2 = new Resident("Benjamin", "Franklin");
            session.persist(resident2);

            Address address1 = new Address("1000 N 4th Street", "Fairfield", "Iowa", "52557", resident1);
            session.persist(address1);

            Address address2 = new Address("2000 N Court Street", "Fairfield", "Iowa", "52556", resident2);
            session.persist(address2);

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

        try {
            session = sessionFactory.openSession();
            tx = session.beginTransaction();

            // retieve all address
            @SuppressWarnings("unchecked")
            List<Address> addressList = session.createQuery("from Address").list();

            System.out.println("\nList of addresss:\n");
            for (Address address : addressList) {
                System.out.println(address);
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
