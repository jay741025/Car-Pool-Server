package com.fet.carpool.serv.service;

import java.util.List;

import com.fet.carpool.serv.dto.CarDto;
import com.fet.carpool.serv.dto.CarNearInfoDto;
import com.fet.carpool.serv.persistence.CarInfo;


public interface CarService {

    public List<CarInfo> list();
    public void setCarInfo(CarDto car);
    public List<CarInfo> getNearCar(CarNearInfoDto car);
    
}
