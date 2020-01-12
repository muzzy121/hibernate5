package com;

import com.dao.CarDao;
import com.entity.Car;
import com.entity.CarType;
import com.entity.VehicleId;
import java.time.LocalDate;
import java.util.List;

public class Start {
    public static void main(String[] args) {
        CarDao carDao = new CarDao();

        VehicleId vehicleId = new VehicleId("fdhgfkdsajhgljkdfa", 888222);

        Car car = new Car(1L, vehicleId, "Fiat","Bravo", LocalDate.of(1990,1,1), CarType.KOMBI);
//        Car carn1 = new Car(2L,"Opel","Insignia", LocalDate.of(2014,1,1), CarType.SPORT);
//        Car carn2 = new Car(3L,"BMW","6", LocalDate.of(2017,1,1), CarType.HATCHBACK);
//        Car carn3 = new Car(4L,"Opel","Astra", LocalDate.of(2018,1,1), CarType.SPORT);

        carDao.add(car);
//        carDao.add(carn1);
//        carDao.add(carn2);
//        carDao.add(carn3);

        Car car1 = carDao.getCar(1L);
        System.out.println(car1);

//        carDao.updateCar(1L, new Car(CarType.HATCHBACK));
//        carDao.deleteCar(car);
        List<Car> cars = carDao.getCarsByType(CarType.SPORT);
        cars.forEach(System.out::println);

    }
}
