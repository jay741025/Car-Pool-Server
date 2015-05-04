package com.fet.carpool.serv.service;

import java.util.List;

import com.fet.carpool.serv.dto.CarDto;
import com.fet.carpool.serv.dto.CarNearInfoDto;
import com.fet.carpool.serv.persistence.Car;


public interface CarService {

    public List<Car> list();
    public void setCarInfo(CarDto car);
    public List<Car> getNearCar(CarNearInfoDto car);
    
}
