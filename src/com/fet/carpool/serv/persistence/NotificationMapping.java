package com.fet.carpool.serv.persistence;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "NOTIFICATION_MAPPING")
public class NotificationMapping {

	private int id;
	private String accountId;
	private String clientType;
	private String registrationId;
	private Date updateDatetime;
	private String enabledStr;    
	
	
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "Id")
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	@Column(name = "AccountId", nullable = false)
	public String getAccountId() {
		return accountId;
	}
	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}
	
	@Column(name = "ClientType")
	public String getClientType() {
		return clientType;
	}
	public void setClientType(String clientType) {
		this.clientType = clientType;
	}
	
	@Column(name = "RegistrationId", nullable = false)
	public String getRegistrationId() {
		return registrationId;
	}
	public void setRegistrationId(String registrationId) {
		this.registrationId = registrationId;
	}
	
	@Column(name = "Datetime" )
	public Date getUpdateDatetime() {
		return updateDatetime;
	}
	public void setUpdateDatetime(Date updateDatetime) {
		this.updateDatetime = updateDatetime;
	}
	
	@Column(name = "Enabled", nullable = false)
	public String getEnabledStr() {
		return enabledStr;
	}
	public void setEnabledStr(String enabledStr) {
		this.enabledStr = enabledStr;
	}

	@Transient
	public boolean isEnabled() {
		return "Y".equalsIgnoreCase(enabledStr);
	}
}
