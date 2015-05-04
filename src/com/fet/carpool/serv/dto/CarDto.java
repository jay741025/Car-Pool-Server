package com.fet.carpool.serv.dto;

import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.map.annotate.JsonSerialize;



@XmlRootElement
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class CarDto {

	private String accountId;
	private String accountName;
	private String accountPic;
	private String latitude;
	private String longitude;
	private int transport ;
	private int status ;
	private String destination;
	
	
	public CarDto() {
		super();
	}


	public String getAccountId() {
		return accountId;
	}


	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	
	public String getAccountPic() {
		return accountPic;
	}


	public void setAccountPic(String accountPic) {
		this.accountPic = accountPic;
	}


	public String getAccountName() {
		return accountName;
	}


	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}


	public String getLatitude() {
		return latitude;
	}


	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}


	public String getLongitude() {
		return longitude;
	}


	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}


	public int getTransport() {
		return transport;
	}


	public void setTransport(int transport) {
		this.transport = transport;
	}


	public int getStatus() {
		return status;
	}


	public void setStatus(int status) {
		this.status = status;
	}


	public String getDestination() {
		return destination;
	}


	public void setDestination(String destination) {
		this.destination = destination;
	}

	
	
	
	
}
