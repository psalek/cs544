package cs544.exercise07_1;

import java.util.List;

import cs544.exercise07_1.model.Airline;
import cs544.exercise07_1.model.Airplane;
import cs544.exercise07_1.model.Airport;
import cs544.exercise07_1.model.Flight;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class App {

    private static final SessionFactory sessionFactory;

    static {
        Configuration configuration = new Configuration();
        configuration.configure();
        ServiceRegistry serviceRegistry
                = new StandardServiceRegistryBuilder().applySettings(
                        configuration.getProperties()).build();
        sessionFactory = configuration.buildSessionFactory(serviceRegistry);
    }

    public static void main(String[] args) {
        // Hibernate placeholders
        Session session = null;
        Transaction tx = null;

        // fill the database
        fillDataBase();

        // a) Flights leaving USA capacity > 500
        try {
            session = sessionFactory.openSession();
            tx = session.beginTransaction();

            // TODO update HQL
            @SuppressWarnings("unchecked")
            List<Flight> flights = session.createQuery("from Flight").list();

            System.out.println("Flight:  Departs:     "
                    + "                  Arrives:");
            for (Flight flight : flights) {
                System.out.printf("%-7s  %-12s %7s %8s  %-12s %7s %8s\n",
                        flight.getFlightnr(), flight.getOrigin().getCity(),
                        flight.getDepartureDate(), flight.getDepartureTime(),
                        flight.getDestination().getCity(), flight
                        .getArrivalDate(), flight.getArrivalTime());
            }
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
                e.printStackTrace(System.err);
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }

        // b) All airlines that use A380 airplanes
        try {
            session = sessionFactory.openSession();
            tx = session.beginTransaction();

            // TODO update HQL
            @SuppressWarnings("unchecked")
            List<Airline> airlines = session.createQuery("from Airline").list();
            System.out.println("Airlines:");
            for (Airline airline : airlines) {
                System.out.printf("%-15s\n", airline.getName());
            }
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
                e.printStackTrace(System.err);
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }

        // c) Flights using 747 planes that don't belong to Star Alliance
        try {
            session = sessionFactory.openSession();
            tx = session.beginTransaction();

            // TODO update HQL
            @SuppressWarnings("unchecked")
            List<Flight> flights = session.createQuery("from Flight").list();
            System.out.println("Flight:  Departs:     "
                    + "                  Arrives:");
            for (Flight flight : flights) {
                System.out.printf("%-7s  %-12s %7s %8s  %-12s %7s %8s\n",
                        flight.getFlightnr(), flight.getOrigin().getCity(),
                        flight.getDepartureDate(), flight.getDepartureTime(),
                        flight.getDestination().getCity(), flight
                        .getArrivalDate(), flight.getArrivalTime());
            }
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
                e.printStackTrace(System.err);
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }

        // d) All flights leaving before 12pm on 08/07/2009
        try {
            session = sessionFactory.openSession();
            tx = session.beginTransaction();

            // TODO update HQL
            @SuppressWarnings("unchecked")
            List<Flight> flights = session.createQuery("from Flight").list();
            System.out.println("Flight:  Departs:     "
                    + "                  Arrives:");
            for (Flight flight : flights) {
                System.out.printf("%-7s  %-12s %7s %8s  %-12s %7s %8s\n",
                        flight.getFlightnr(), flight.getOrigin().getCity(),
                        flight.getDepartureDate(), flight.getDepartureTime(),
                        flight.getDestination().getCity(), flight
                        .getArrivalDate(), flight.getArrivalTime());
            }
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
                e.printStackTrace(System.err);
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
        System.exit(0);
    }

    public static void fillDataBase() {
        Session session = null;
        Transaction tx = null;

        try {
            session = sessionFactory.openSession();
            tx = session.beginTransaction();

            Airport ams = new Airport("AMS", "Schiphol", "Amsterdam",
                    "The Netherlands");
            Airport lhr = new Airport("LHR", "London Heathrow", "London", "UK");
            Airport fra = new Airport("FRA", "Frankfurt International Airport",
                    "Frankfurt", "Germany");
            Airport dtw = new Airport("DTW", "Detroid City", "Detroid", "USA");
            Airport ord = new Airport("ORD", "Chicago O'hare International",
                    "Chicago", "USA");
            Airport lax = new Airport("LAX", "Los Angeles International",
                    "Los Angeles", "USA");
            Airport jfk = new Airport("JFK", "John F. Kennedy International",
                    "New York", "USA");
            Airport nrt = new Airport("NRT", "Narita International Airport",
                    "Tokyo", "Japan");
            Airport syd = new Airport("SYD", "Kingsford Smith", "Sydney",
                    "Australia");
            Airport sin = new Airport("SIN", "Changi Airport", "Singapore",
                    "Singapore");

            Airplane airplane1 = new Airplane("12345", "A380", 519);
            Airplane airplane2 = new Airplane("54321", "747", 416);
            Airplane airplane3 = new Airplane("23451", "A380", 519);
            Airplane airplane4 = new Airplane("43215", "747", 416);
            Airplane airplane5 = new Airplane("34512", "A380", 519);
            Airplane airplane6 = new Airplane("32154", "747", 416);

            Airline airline1 = new Airline("SkyTeam");
            Airline airline2 = new Airline("oneworld");
            Airline airline3 = new Airline("Star Alliance");

            Flight flight1 = new Flight("NW 36", "08/06/2009", "7:10 pm",
                    "08/07/2009", "9:00 am", airline1, dtw, ams, airplane1);
            Flight flight2 = new Flight("NW 96", "08/06/2009", "3:05 pm",
                    "08/07/2009", "1:45 pm", airline1, nrt, dtw, airplane2);
            Flight flight3 = new Flight("QF 12", "08/05/2009", "10:30 pm",
                    "08/07/2009", "6:15 am", airline2, lax, syd, airplane3);
            Flight flight4 = new Flight("QF 21", "08/06/2009", "9:55 pm",
                    "08/07/2009", "6:55 am", airline2, syd, nrt, airplane4);
            Flight flight5 = new Flight("UA 944", "08/06/2009", "2:30 pm",
                    "08/07/2009", "5:45 am", airline3, ord, fra, airplane5);
            Flight flight6 = new Flight("UA 934", "08/06/2009", "12:59 pm",
                    "08/07/2009", "7:30 am", airline3, lax, lhr, airplane6);
            Flight flight7 = new Flight("NW 8445", "08/07/2009", "7:15 am",
                    "08/07/2009", "7:40 am", airline1, ams, lhr, airplane1);
            Flight flight8 = new Flight("NW 1689", "08/07/2009", "12:05 pm",
                    "08/07/2009", "12:21 pm", airline1, dtw, ord, airplane2);
            Flight flight9 = new Flight("QF 3101", "08/07/2009", "3:00 pm",
                    "08/07/2009", "11:39 pm", airline2, lax, jfk, airplane3);
            Flight flight10 = new Flight("QF 4022", "08/07/2009", "11:05 am",
                    "08/07/2009", "5:15 pm", airline2, nrt, sin, airplane4);
            Flight flight11 = new Flight("UA 941", "08/07/2009", "12:45 pm",
                    "08/07/2009", "2:53 pm", airline3, fra, ord, airplane5);
            Flight flight12 = new Flight("UA 4842", "08/07/2009", "8:10 am",
                    "08/07/2009", "10:38 am", airline3, lhr, ams, airplane6);

            session.persist(flight1);
            session.persist(flight2);
            session.persist(flight3);
            session.persist(flight4);
            session.persist(flight5);
            session.persist(flight6);
            session.persist(flight7);
            session.persist(flight8);
            session.persist(flight9);
            session.persist(flight10);
            session.persist(flight11);
            session.persist(flight12);

            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
                e.printStackTrace(System.err);
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
}
