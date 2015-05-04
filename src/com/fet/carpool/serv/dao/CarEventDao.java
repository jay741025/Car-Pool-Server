package com.fet.carpool.serv.dao;

import java.util.List;

import com.fet.carpool.serv.persistence.CarEvent;



public interface CarEventDao {

    public List<CarEvent> list();   
    public Boolean findCarEventByAccountId( String accountId);      
    public void updateCarEvent(CarEvent carEvent);    
    public void addCarEvent(CarEvent carEvent);
    
}
