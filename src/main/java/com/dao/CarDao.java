package com.dao;

import org.hibernate.Session;
import com.HibernateConfig;
import com.entity.*;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.beans.Transient;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class CarDao {
    private SessionFactory sessionFactory = HibernateConfig.INSTANCE.getSessionFactory();
    private Session session;

    public CarDao() {
    }

    public Car getCar(Long id) {
        session = sessionFactory.openSession();
        Car car = session.get(Car.class, id);
        session.close();
        return car;
    }

    public void add(Car car) {
        session = sessionFactory.openSession();
        Transaction transaction = session.getTransaction();
        try {
            transaction.begin();
            session.save(car);
            transaction.commit();
        } catch (Exception ex) {
            transaction.rollback();
            ex.printStackTrace();
        } finally {
            session.close();
        }
    }

    public void updateCar(Long id, Car newCar) {
        session = sessionFactory.openSession();
        Transaction transaction = session.getTransaction();
        try {
            transaction.begin();
            Car car = session.find(Car.class, id);
            car.setCarType(newCar.getCarType());
            car.setMark(newCar.getMark());
            car.setModel(newCar.getModel());
            car.setProdYear(newCar.getProdYear());
            transaction.commit();
        } catch (Exception ex) {
            transaction.rollback();
            ex.printStackTrace();
        } finally {
            session.close();
        }
    }
    public void deleteCar(Car car) {
        session = sessionFactory.openSession();
        Transaction transaction = session.getTransaction();
        try {
            transaction.begin();
            session.delete(car);
            transaction.commit();
        } catch (Exception ex) {
            transaction.rollback();
            ex.printStackTrace();
        } finally {
            session.close();
        }
    }
    public List<Car> getCarsByType(CarType carType){
        session = sessionFactory.openSession();
        Transaction transaction = session.getTransaction();
        List<BigInteger> resultList = null;
        try {
            transaction.begin();
            String sql = "SELECT id FROM cars WHERE cars.car_type = ? ";
            Query query = session.createNativeQuery(sql);
            query.setParameter(1, carType.ordinal()); // zwróc uwage na enum
            resultList = query.getResultList();
            transaction.commit();
        } catch (Exception ex) {
            transaction.rollback();
            ex.printStackTrace();
        } finally {
            session.close();
//            Set<Car> carList = new HashSet<>();
//            carList.addAll(resultList);
            List<Car> carList = new ArrayList<>();
            resultList.forEach(id -> carList.add(getCar(id.longValue())));
            return carList;
        }
    }
}
