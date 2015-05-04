package com.fet.carpool.serv.service.impl;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.ObjectWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fet.carpool.serv.dao.CarEventDao;

import com.fet.carpool.serv.dao.NotificationMappingDao;
import com.fet.carpool.serv.dto.CarEventDto;

import com.fet.carpool.serv.persistence.CarEvent;

import com.fet.carpool.serv.service.BaseService;
import com.fet.carpool.serv.service.CarEventService;



@Transactional
@Service("carEventService")
public class CarEventServiceImpl extends BaseService implements CarEventService {

    @Autowired
    private CarEventDao carEventDao;

    @Autowired
	private NotificationMappingDao notificationMappingDao;
    
    protected Logger logger;

	@Override
	public List<CarEvent> list() {		
		return carEventDao.list();
	}

	@Override
	public void setCarEvent(CarEventDto carDto) {	
		
		CarEvent car = new CarEvent();
		try {
		
			car.setAccountId(carDto.getAccountId());
			
			car.setAccountName(URLDecoder.decode(carDto.getAccountName(), "UTF-8"));
			
			car.setAccountPic(carDto.getAccountPic());
			car.setEventType(carDto.getEventType());
			car.setMessage(URLDecoder.decode(carDto.getMessage(), "UTF-8"));	
			car.setToId(carDto.getToId());
			car.setToName(carDto.getToName());
			car.setDatetime(new Date());	
			carEventDao.addCarEvent(car);	
			
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
		String msg;
		try {
			msg = ow.writeValueAsString(car);
			sendDelayNotification(msg,
					"CarEvent", notificationMappingDao.getByAccount(carDto.getToId()),
					1) ;
			
		} catch (JsonGenerationException e) {
			
			e.printStackTrace();
		} catch (JsonMappingException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		
				
		
		
	}

	
    
    

}
