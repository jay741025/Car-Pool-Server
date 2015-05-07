package com.fet.carpool.serv.rws;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;


import org.apache.log4j.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fet.carpool.serv.dto.AccountRegistrationBean;
import com.fet.carpool.serv.dto.CarDto;
import com.fet.carpool.serv.dto.CarEventDto;
import com.fet.carpool.serv.dto.CarNearInfoDto;


import com.fet.carpool.serv.persistence.CarFriends;
import com.fet.carpool.serv.persistence.CarInfo;

import com.fet.carpool.serv.service.AccountService;
import com.fet.carpool.serv.service.CarEventService;
import com.fet.carpool.serv.service.CarFriendsService;
import com.fet.carpool.serv.service.CarService;





@Component("carWs")
@Path("car")
public class CarWs {

	@SuppressWarnings("unused")
	@Context
	private HttpServletResponse httpServletResponse;
	@SuppressWarnings("unused")
	@Context
	private HttpServletRequest httpServletRequest;

	@Autowired
	private CarService carServ;
	@Autowired
	private CarEventService carEventServ;	
	@Autowired
	private AccountService accountService;
	@Autowired
	private CarFriendsService carFriendsService;
	
	protected Logger logger;
	
	
	@POST
    @Path("createAccount")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public boolean createSimAccountIfNotFound( AccountRegistrationBean inputAccount ) {
    	
    	if( inputAccount == null || inputAccount.getAccountId() == null || inputAccount.getAccountId().length() < 12 )
    		return false;
    	
    	CarDto car = new CarDto();
    	car.setAccountId(inputAccount.getAccountId());
    	car.setAccountName(inputAccount.getAccountName());
    	car.setAccountPic(inputAccount.getAccountPic());
    	car.setTransport(1);
    	car.setStatus(0);
    	car.setLatitude("0");
    	car.setLongitude("0");
    	carServ.setCarInfo(car);
    	
    	// add regId
    	if( inputAccount.getRegClientId() != null )
    		accountService.updateRegistrationId(inputAccount.getAccountId(), 
    					inputAccount.getRegClientType(), 
    					inputAccount.getRegClientId() );
    	
    	return true;
    }
	
	@POST
	@Path("setCarInfo")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String setCarInfo(CarDto car)
			throws UnsupportedEncodingException {

		logger = Logger.getLogger(getClass());
		logger.debug("setCarInfo");	
		carServ.setCarInfo(car);		
		return "OK";
	}
	
	@POST
	@Path("getNearCar")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public List<CarInfo> getNearCar(CarNearInfoDto car)
			throws UnsupportedEncodingException {

		logger = Logger.getLogger(getClass());
		logger.debug("getNearCar");	
		List<CarInfo> carList = carServ.getNearCar(car);	
		//List<Car> carList = carServ.list();	
		return carList;
	}
	
	@POST
	@Path("setCarEvent")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String setCarEvent(CarEventDto carEvent)
			throws UnsupportedEncodingException {

		logger = Logger.getLogger(getClass());
		logger.debug("setsetCarEvent");	
		carEventServ.setCarEvent(carEvent);	
		
		return "OK";
	}
	
	@POST
	@Path("addCarFriends")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String addCarFriends(CarFriends carFriends)
			throws UnsupportedEncodingException {

		logger = Logger.getLogger(getClass());
		logger.debug("addCarFriends");	
		carFriendsService.addCarFriends(carFriends);		
		return "OK";
	}
	
	
	
	@GET
    @Path("getCarFriends")
    @Produces(MediaType.APPLICATION_JSON)
    public List<CarInfo> getCarFriends(@QueryParam("accountId") String accountId) {
		logger = Logger.getLogger(getClass());
		logger.debug("getCarFriends");	
		return carFriendsService.findCarFriendsByAccountId(accountId);
    }
	
	

	
}
