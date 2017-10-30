/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs544.validation;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author mzijlstra
 */
@Transactional
public class CarDao  {
    private SessionFactory sf;
    
    public void setSessionFactory(SessionFactory sf) {
        this.sf = sf;
    }

    public List<Car> getAll() {
        Query q = sf.getCurrentSession().createQuery("from Car");
        return q.list();
    }

    public void add(Car car) {
        sf.getCurrentSession().persist(car);
    }

    public Car get(int id) {
        return (Car) sf.getCurrentSession().load(Car.class, id);
    }

    public void update(int carId, Car car) {
        Car c = get(carId);
        c.setColor(car.getColor());
        c.setMake(car.getMake());
        c.setModel(car.getModel());
        c.setYear(car.getYear());
    }

    public void delete(int carId) {
        Car c = get(carId);
        sf.getCurrentSession().delete(c);
    }
}
