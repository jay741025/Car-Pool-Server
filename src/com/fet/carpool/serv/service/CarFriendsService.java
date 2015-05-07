package com.fet.carpool.serv.service;

import java.util.List;

import com.fet.carpool.serv.persistence.CarFriends;
import com.fet.carpool.serv.persistence.CarInfo;

public interface CarFriendsService {
    public List<CarInfo> findCarFriendsByAccountId( String accountId);
    public void addCarFriends(CarFriends carFriends);     
}
