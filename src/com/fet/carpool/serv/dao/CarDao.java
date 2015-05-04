package com.fet.carpool.serv.dao;

import java.util.List;

import com.fet.carpool.serv.persistence.Car;



public interface CarDao {

    public List<Car> list();   
    public Car findCarByAccountId( String accountId);      
    public void updateCarInfo(Car car);    
    public void addCarInfo(Car car);
    
}
