package com.entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

@Entity
@Table(name = "cars")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Embedded
    private VehicleId vehicleInfo;

    private String mark;
    private String model;
    @Column(name="production_year")
    private LocalDate prodYear;
    @Transient
    private int age;

    @Enumerated(value = EnumType.ORDINAL)
    @Column(name="car_type")
    private CarType carType;

    public Car(long id, VehicleId vehicleInfo, String mark, String model, LocalDate prodYear, CarType carType) {
        this.id = id;
        this.vehicleInfo = vehicleInfo;
        this.mark = mark;
        this.model = model;
        this.prodYear = prodYear;
        this.carType = carType;
    }

    public Car() {
    }

    public Car(CarType carType){
        this.carType = carType;
    }

    public int getAge() {
        return age;
    }

    public Car setAge(int age) {
        this.age = age;
        return this;
    }

    public String getMark() {
        return mark;
    }

    public Car setMark(String mark) {
        this.mark = mark;
        return this;
    }

    public CarType getCarType() {
        return carType;
    }

    public Car setCarType(CarType carType) {
        this.carType = carType;
        return this;
    }

    public String getModel() {
        return model;
    }

    public Car setModel(String model) {
        this.model = model;
        return this;
    }

    public LocalDate getProdYear() {
        return prodYear;
    }

    public Car setProdYear(LocalDate prodYear) {
        this.prodYear = prodYear;
        return this;
    }

    public long getId() {
        return id;
    }

    public Car setId(long id) {
        this.id = id;
        return this;
    }

    public VehicleId getVehicleInfo() {
        return vehicleInfo;
    }

    public Car setVehicleInfo(VehicleId vehicleInfo) {
        this.vehicleInfo = vehicleInfo;
        return this;
    }

    @PostLoad
    private void calculateAge(){
        age = (int) ChronoUnit.YEARS.between(prodYear, LocalDate.now());

    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", mark='" + mark + '\'' +
                ", model='" + model + '\'' +
                ", prodYear=" + prodYear +
                ", age=" + age +
                ", carType=" + carType +
                '}';
    }
}
