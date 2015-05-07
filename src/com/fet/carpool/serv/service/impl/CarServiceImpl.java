package com.fet.carpool.serv.service.impl;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fet.carpool.serv.dao.CarDao;

import com.fet.carpool.serv.dto.CarDto;
import com.fet.carpool.serv.dto.CarNearInfoDto;

import com.fet.carpool.serv.persistence.CarInfo;

import com.fet.carpool.serv.service.CarService;



@Transactional
@Service("carService")
public class CarServiceImpl implements CarService {

    @Autowired
    private CarDao carDao;    


	@Override
	public List<CarInfo> list() {		
		return carDao.list();
	}

	@Override
	public void setCarInfo(CarDto carDto) {	
		
		CarInfo heaveCar = carDao.findCarByAccountId(carDto.getAccountId());	
		try {
			if(heaveCar != null ){		
				
				heaveCar.setAccountName(URLDecoder.decode(carDto.getAccountName(), "UTF-8"));
				
				heaveCar.setLatitude(carDto.getLatitude());
				heaveCar.setAccountPic(carDto.getAccountPic());
				heaveCar.setLongitude(carDto.getLongitude());
				heaveCar.setTransport(carDto.getTransport());
				heaveCar.setStatus(carDto.getStatus());				
				heaveCar.setDatetime(new Date());
				if(carDto.getDestination() !=null && !carDto.getDestination().equals("")){
					heaveCar.setDestination(URLDecoder.decode(carDto.getDestination(), "UTF-8"));
				}
				carDao.updateCarInfo(heaveCar);			
			}else{			
				CarInfo car = new CarInfo();
				car.setAccountId(carDto.getAccountId());
				car.setAccountName(URLDecoder.decode(carDto.getAccountName(), "UTF-8"));
				car.setAccountPic(carDto.getAccountPic());
				car.setLatitude(carDto.getLatitude());
				car.setLongitude(carDto.getLongitude());
				car.setStatus(carDto.getStatus());
				car.setTransport(carDto.getTransport());
				if(carDto.getDestination() !=null && !carDto.getDestination().equals("")){
					car.setDestination(URLDecoder.decode(carDto.getDestination(), "UTF-8"));				
				}
				car.setDatetime(new Date());
				carDao.addCarInfo(car);
			}
		
		} catch (UnsupportedEncodingException e) {
			
		}
		
		
	}

	@Override
	public List<CarInfo> getNearCar(CarNearInfoDto carNearInfo) {
		List<CarInfo> carListDb =carDao.list() ;
		List<CarInfo> carList = new ArrayList<CarInfo>();
		if(carListDb != null && carListDb.size() > 0){		
			for(CarInfo car :carListDb){
				if(!car.getAccountId().equals(carNearInfo.getAccountId())  && car.getStatus() > 0 ){
					double d =Math.sqrt(Math.pow(Double.parseDouble(carNearInfo.getLatitude()) - Double.parseDouble(car.getLatitude()), 2) 
							+ Math.pow(Double.parseDouble(carNearInfo.getLongitude()) - Double.parseDouble(carNearInfo.getLongitude()), 2));
					if(d<=Double.parseDouble(carNearInfo.getDistance())){
						carList.add(car);
					}
				}
			}
		}
		return carList ;
		
	}
    
    

}
