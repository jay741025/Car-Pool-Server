package com.fet.carpool.serv.dao;

import java.util.List;

import com.fet.carpool.serv.persistence.CarFriends;



public interface CarFriendsDao {

    
    public List<CarFriends> findCarFriendsByAccountId( String accountId);  
    public CarFriends findCarFriendsById( String accountId ,String friendsId);     
    //public void updateCarInfo(CarInfo car);    
    public void addFriends(CarFriends carFriends);
    
}
