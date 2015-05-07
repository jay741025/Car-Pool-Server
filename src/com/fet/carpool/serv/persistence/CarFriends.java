package com.fet.carpool.serv.persistence;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CAR_FRIENDS")
public class CarFriends {
	
	private int id ;
	private String accountId;
	private String friendsId;	
    private Date datetime;
    
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
	
	@Column(name = "FriendsId", nullable = false)
	public String getFriendsId() {
		return friendsId;
	}

	public void setFriendsId(String friendsId) {
		this.friendsId = friendsId;
	}

	@Column(name = "Datetime", nullable = false)
	public Date getDatetime() {
		return datetime;
	}
	public void setDatetime(Date datetime) {
		this.datetime = datetime;
	}
    
    
  
}
