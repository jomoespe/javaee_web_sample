package com.josemorenoesteban.lab.websample.service;

import com.josemorenoesteban.lab.websample.rest.Car;
import javax.enterprise.inject.Default;
import javax.inject.Named;

@Named("carsImpl") @Default
public class CarsServicePojo implements CarsService {
    @Override
    public Car getCar(String id) {
        Car car = new Car();
        car.id        = id;
        car.latitude  = 40.437589;
        car.longitude = -3.628133;
        return car;
    } 
}
