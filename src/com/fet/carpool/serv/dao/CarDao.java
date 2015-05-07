package com.fet.carpool.serv.dao;

import java.util.List;

import com.fet.carpool.serv.persistence.CarInfo;



public interface CarDao {

    public List<CarInfo> list();   
    public CarInfo findCarByAccountId( String accountId);      
    public void updateCarInfo(CarInfo car);    
    public void addCarInfo(CarInfo car);
    
}
