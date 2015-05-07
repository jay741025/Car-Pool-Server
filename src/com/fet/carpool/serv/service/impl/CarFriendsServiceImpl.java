package com.fet.carpool.serv.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fet.carpool.serv.dao.CarDao;
import com.fet.carpool.serv.dao.CarFriendsDao;

import com.fet.carpool.serv.persistence.CarFriends;
import com.fet.carpool.serv.persistence.CarInfo;

import com.fet.carpool.serv.service.CarFriendsService;



@Transactional
@Service("carFriendsService")
public class CarFriendsServiceImpl implements CarFriendsService {

    @Autowired
    private CarFriendsDao carFriendsDao;  
    @Autowired
    private CarDao carDao;   

	

	@Override
	public void addCarFriends(CarFriends carFriends) {
		
		CarFriends friend =carFriendsDao.findCarFriendsById(carFriends.getAccountId(), carFriends.getFriendsId());
		if(friend==null ){
			carFriends.setDatetime(new Date());
			carFriendsDao.addFriends(carFriends);
		}
	}



	@Override
	public List<CarInfo> findCarFriendsByAccountId(String accountId) {
		List<CarFriends> Friends = carFriendsDao.findCarFriendsByAccountId(accountId);
		List<CarInfo> carList =new ArrayList<CarInfo>();
		if(Friends !=null && Friends.size()> 0 ){
			for(int i = 0 ;i<Friends.size() ;i++ ){				
				CarInfo car =carDao.findCarByAccountId(Friends.get(i).getFriendsId());
				if(car!=null ){
					carList.add(car);
				}
			}
		}
		
		
		
		return carList;
	}
    
    

}
