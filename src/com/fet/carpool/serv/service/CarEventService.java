package com.fet.carpool.serv.service;

import java.util.List;


import com.fet.carpool.serv.dto.CarEventDto;

import com.fet.carpool.serv.persistence.CarEvent;


public interface CarEventService {

    public List<CarEvent> list();
    public void setCarEvent(CarEventDto car);
    
}
