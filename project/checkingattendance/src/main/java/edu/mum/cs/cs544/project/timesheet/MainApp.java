package edu.mum.cs.cs544.project.timesheet;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import edu.mum.cs.cs544.project.timesheet.entity.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by tony on 1/20/17.
 */
public class MainApp {
	private static final String DATA_FILE_LOCATION = "src/main/resources/datafiles/";
	
    private static final SessionFactory sessionFactory;

    static {
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");

        sessionFactory = configuration.buildSessionFactory();
    }

    private static org.hibernate.Session session = null;
    private static Transaction tx = null;

    public static void main(String[] args) {
        // fill the database
        fillDataBase();

        System.exit(0);
    }

    private static void fillDataBase() {
        try {
            session = sessionFactory.openSession();
            tx = session.beginTransaction();
            // Create and persist Courses
            getCourseList().stream().forEach(course -> session.persist(course));

            // Create and persist CourseOffering
            getCourseOfferingList().stream().forEach(courseOffering -> session.persist(courseOffering));

            // Create and persit Timeslots
            getTimeslotList().stream().forEach(timeslot -> session.persist(timeslot));

            // Create and persist Sessions
            getSessionList().stream().forEach(s -> session.persist(s));

            // Create and persist Students
            getStudentList().stream().forEach(student -> session.persist(student));

            // Create and persist Locations
            getLocationList().stream().forEach(location -> session.persist(location));

            // Create and persist AttendanceRecords
            getAttendanceRecordList().stream().forEach(attendanceRecord -> session.persist(attendanceRecord));

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

    private static List<Course> courseList = null;
    private static List<CourseOffering> courseOfferingList = null;
    private static List<Timeslot> timeslotList = null;
    private static List<Student> studentList = null;
    private static List<Session> sessionList = null;
    private static List<Location> locationList = null;
    private static List<AttendanceRecord> attendanceRecordList = null;

    private static List<Course> getCourseList(){
        if (courseList != null) return courseList;

        String fileName = "course.csv";

        //read file into stream, try-with-resources
        try (Stream<String> stream = Files.lines(Paths.get(DATA_FILE_LOCATION + fileName))) {
            courseList = stream.map(line -> {
                Course c = new Course();
                String[] atts = line.split(",");

                c.setCourseId(atts[0]);
                c.setName(atts[1]);
                if(atts.length == 3) {
                    c.setName(atts[2]);
                }
                return c;
            }).collect(Collectors.toList());

        } catch (IOException e) {
            e.printStackTrace();
        }

        return courseList;
    }

    private static List<CourseOffering> getCourseOfferingList(){
        if(courseOfferingList != null) return courseOfferingList;

        String fileName = "courseoffering.csv";
        //read file into stream, try-with-resources
        try (Stream<String> stream = Files.lines(Paths.get(DATA_FILE_LOCATION + fileName))) {
            courseOfferingList = stream.map(line -> {
                CourseOffering co = new CourseOffering();
                String[] atts = line.split(",");

                co.setCourseOfferingId(atts[0]);
                Course c = getCourseList()
                        .stream()
                        .filter(course -> course.getCourseId().equals(atts[1]))
                        .findFirst()
                        .get();
                co.setCourse(c);
                co.setStartDate(LocalDate.parse(atts[2], DateTimeFormatter.ofPattern("M/d/yy")));
                co.setEndDate(LocalDate.parse(atts[3], DateTimeFormatter.ofPattern("M/d/yy")));
                return co;
            }).collect(Collectors.toList());

        } catch (IOException e) {
            e.printStackTrace();
        }

        return courseOfferingList;
    }

    private static List<Timeslot> getTimeslotList(){
        if(timeslotList != null) return timeslotList;

        String fileName = "timeslot.csv";
        //read file into stream, try-with-resources
        try (Stream<String> stream = Files.lines(Paths.get(DATA_FILE_LOCATION + fileName))) {
            timeslotList = stream.map(line -> {
                Timeslot ts = new Timeslot();
                String[] atts = line.split(",");

                ts.setAbbreviation(atts[0]);
                ts.setDescription(atts[1]);
                ts.setBeginTime(LocalTime.parse(atts[2], DateTimeFormatter.ofPattern("k:m")));
                ts.setEndTime(LocalTime.parse(atts[3], DateTimeFormatter.ofPattern("k:m")));
                return ts;
            }).collect(Collectors.toList());

        } catch (IOException e) {
            e.printStackTrace();
        }

        return timeslotList;
    }

    private static List<Student> getStudentList() {
        if (studentList != null) return studentList;

        String fileName = "student.csv";
        //read file into stream, try-with-resources
        try (Stream<String> stream = Files.lines(Paths.get(DATA_FILE_LOCATION + fileName))) {
            studentList = stream.map(line -> {
                Student s = new Student();
                String[] atts = line.split(",");

                s.setStudentId(atts[0]);
                s.setFirstName(atts[1]);
                s.setLastName(atts[2]);
                s.setBarCode(atts[3]);
                return s;
            }).collect(Collectors.toList());

        } catch (IOException e) {
            e.printStackTrace();
        }

        return studentList;
    }

    private static List<Session> getSessionList(){
        if (sessionList != null) return sessionList;

        String fileName = "session.csv";
        //read file into stream, try-with-resources
        try (Stream<String> stream = Files.lines(Paths.get(DATA_FILE_LOCATION + fileName))) {
            sessionList = stream.map(line -> {
                Session s = new Session();
                String[] atts = line.split(",");

                CourseOffering co = getCourseOfferingList()
                        .stream()
                        .filter(courseOffering -> courseOffering.getCourseOfferingId().equals(atts[2]))
                        .findFirst()
                        .get();
                s.setCourseOffering(co);
                Timeslot ts = getTimeslotList()
                        .stream()
                        .filter(timeslot -> timeslot.getAbbreviation().equals(atts[3]))
                        .findFirst()
                        .get();
                s.setTimeslot(ts);
                s.setDate(LocalDate.parse(atts[4], DateTimeFormatter.ofPattern("M/d/yy")));
                return s;
            }).collect(Collectors.toList());

        } catch (IOException e) {
            e.printStackTrace();
        }

        return sessionList;
    }

    private static List<Location> getLocationList(){
        if (locationList != null) return locationList;

        String fileName = "location.csv";
        //read file into stream, try-with-resources
        try (Stream<String> stream = Files.lines(Paths.get(DATA_FILE_LOCATION + fileName))) {
            locationList = stream.map(line -> {
                Location l = new Location();
                String[] atts = line.split(",");

                l.setLocationId(atts[0]);
                l.setName(atts[1]);
                return l;
            }).collect(Collectors.toList());

        } catch (IOException e) {
            e.printStackTrace();
        }

        return locationList;
    }

    private static List<AttendanceRecord> getAttendanceRecordList(){
        if (attendanceRecordList != null) return attendanceRecordList;

        String fileName = "attendance.csv";
        //read file into stream, try-with-resources
        try (Stream<String> stream = Files.lines(Paths.get(DATA_FILE_LOCATION + fileName))) {
            attendanceRecordList = stream.map(line -> {
                AttendanceRecord ar = new AttendanceRecord();
                String[] atts = line.split(",");

                Student student = getStudentList()
                        .stream()
                        .filter(s -> s.getBarCode().equals(atts[0]))
                        .findFirst()
                        .get();
                ar.setStudent(student);
                ar.setDate(LocalDate.parse(atts[1], DateTimeFormatter.ofPattern("M/d/yy")));
                Timeslot ts = getTimeslotList()
                        .stream()
                        .filter(timeslot -> timeslot.getAbbreviation().equals(atts[2]))
                        .findFirst()
                        .get();
                ar.setTimeslot(ts);
                Location location = getLocationList()
                        .stream()
                        .filter(l -> l.getLocationId().equals(atts[3]))
                        .findFirst()
                        .get();
                ar.setLocation(location);

                return ar;
            }).collect(Collectors.toList());

        } catch (IOException e) {
            e.printStackTrace();
        }

        return attendanceRecordList;
    }
}
