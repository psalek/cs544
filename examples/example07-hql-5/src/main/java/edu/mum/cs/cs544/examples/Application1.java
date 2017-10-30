package edu.mum.cs.cs544.examples;

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

public class Application1 {

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
            
            Faculty alex = new Faculty("Alex", "Altman", 20000.0);
            Faculty russ = new Faculty("Charlene", "Peters", 20000.0);
            
            session.persist(alex);
            session.persist(russ);
            
            Course cs544 = new Course("CS544", "Enterprise Architecture", "This course focuses on teaching the principles and practices that are used for developing larger scale enterprise applications.  We will examine the different architectural layers that are frequently used and different technologies associated with these layers, including Object Relational Mapping (ORM), Dependency Injection  (DI), Aspect Oriented Programming (AOP), and integration with other applications through Web Services (RESTfull and SOAP) and Messaging.");
            Course cs472 = new Course("CS472", "Web Application Programming", "This course provides a systematic introduction to programming interactive and dynamic web applications. The course is intended for individuals with little or no prior web application programming experience. This offering will use PHP for server side processing. PHP is a widely used web application server side scripting language. It has been used for some very large systems (e.g., Facebook), but generally is used for smaller applications. The course will introduce HTML and CSS as they are currently used, and also covers Javascript, Ajax, jQuery, and web security.");
            
            session.persist(cs544);
            session.persist(cs472);
            
            alex.setCourse(cs544);
            russ.setCourse(cs472);
            
            Student s1 = new Student("Russell", "Rose", new Date());
            Student s2 = new Student("Jennifer", "Cannon", new Date());
            Student s3 = new Student("Pablo", "Bowen", new Date());
            Student s4 = new Student("Clay", "Phillips", new Date());
            Student s5 = new Student("Sam", "Sandoval", new Date());
            Student s6 = new Student("Felix", "Edwards", new Date());
            Student s7 = new Student("Elsa", "Castro", new Date());
            Student s8 = new Student("Angelina", "White", new Date());
            
            session.persist(s1);
            session.persist(s2);
            session.persist(s3);
            session.persist(s4);
            session.persist(s5);
            session.persist(s6);
            session.persist(s7);
            session.persist(s8);
            
            CourseOffering offering1 = new CourseOffering(cs544, new Date());
            CourseOffering offering2 = new CourseOffering(cs544, new Date());
            CourseOffering offering3 = new CourseOffering(cs472, new Date());
            CourseOffering offering4 = new CourseOffering(cs472, new Date());
            
            session.persist(offering1);
            session.persist(offering2);
            session.persist(offering3);
            session.persist(offering4);
            
            s1.setCourseOffering(offering1);
            s2.setCourseOffering(offering1);
            
            s3.setCourseOffering(offering2);
            s4.setCourseOffering(offering2);
            
            s5.setCourseOffering(offering3);
            s6.setCourseOffering(offering3);
            
            s7.setCourseOffering(offering4);
            s8.setCourseOffering(offering4);

            tx.commit();
            System.out.println("Finished savig objects");
            tx = session.beginTransaction();

            // Query
            Query query = session.createQuery("from Person");
            @SuppressWarnings("unchecked")
			List<Person> persons = query.list();
            for (Person person : persons) {
                System.out.println(person);
            }
            
            //Query query1 = session.createQuery("Select f from Faculty f join f.course c where c.courseId = 'CS544'");
            Query query1 = session.createQuery("Select p from Person p where p.class=Faculty AND p.course.courseId = 'CS544'");
            @SuppressWarnings("unchecked")
			List<Faculty> result1 = query1.list();
            for (Faculty f : result1) {
                System.out.println(f);
            }
            
            Query query2 = session.createQuery("Select s from Student s where s.courseOffering.course.courseId = 'CS544'");
            @SuppressWarnings("unchecked")
			List<Student> result2 = query2.list();
            for (Student s : result2) {
                System.out.println(s);
            }
            
            Query query3 = session.createQuery("Select s from Person s JOIN s.courseOffering c JOIN c.course c1 where s.class = Student AND c1.courseId = 'CS544'");
            @SuppressWarnings("unchecked")
			List<Student> result3 = query3.list();
            for (Student s : result3) {
                System.out.println(s);
            }
            
            tx.commit();
            System.out.println("Finished queries");


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
