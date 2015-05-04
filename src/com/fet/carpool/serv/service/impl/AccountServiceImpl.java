package com.fet.carpool.serv.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fet.carpool.serv.dao.NotificationMappingDao;
import com.fet.carpool.serv.persistence.NotificationMapping;
import com.fet.carpool.serv.service.AccountService;
import com.fet.carpool.serv.service.BaseService;

@Transactional
@Service("accountService")
public class AccountServiceImpl extends BaseService implements AccountService {

	
    
    @Autowired
    private NotificationMappingDao notificationMappingDao;
    
   
	@Override
	public void updateRegistrationId(String accountId, String clientType,
			String registrationId) {
		
		if( accountId == null )
			return; 	// dp nothing
		
		if( registrationId == null )
			return; 	// dp nothing
		
		boolean regIdExist = notificationMappingDao.isRegistrationIdEnabled(accountId, registrationId);
		if( !regIdExist ) {
			
			NotificationMapping notificationMapping = new NotificationMapping();
			notificationMapping.setAccountId(accountId);
			notificationMapping.setClientType(clientType);
			notificationMapping.setRegistrationId(registrationId);
			notificationMapping.setEnabledStr("Y");
			notificationMapping.setUpdateDatetime(new Date());
			notificationMappingDao.insertNotificationMapping(notificationMapping);
		}else{			
			
			List<NotificationMapping> notificationList =notificationMappingDao.getByAccount(accountId);
			NotificationMapping notification =notificationList.get(0);
			notification.setRegistrationId(registrationId);
			notification.setEnabledStr("Y");
			notification.setUpdateDatetime(new Date());
			notificationMappingDao.updateNotificationMapping(notification);
		}
	}


}
