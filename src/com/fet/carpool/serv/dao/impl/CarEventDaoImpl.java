package com.fet.carpool.serv.dao.impl;

import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import com.fet.carpool.serv.dao.BaseDao;
import com.fet.carpool.serv.dao.CarEventDao;

import com.fet.carpool.serv.persistence.CarInfo;
import com.fet.carpool.serv.persistence.CarEvent;




@Repository("carEventDao")
public class CarEventDaoImpl extends BaseDao implements CarEventDao {

    @Autowired
    private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	@Override
	public List<CarEvent> list() {
		String sql = "SELECT * FROM CAR_EVENT " ;
		SQLQuery query = sessionFactory.getCurrentSession().createSQLQuery(sql);		
		query.setResultTransformer(Transformers.aliasToBean(CarEvent.class));		
		List<CarEvent> list = query.list();
		if( list == null || list.size() == 0 )
			return null;
		
		return list;
	}

	

	@Override
	public Boolean findCarEventByAccountId(String accountId) {
		String sql = "SELECT * FROM CAR_EVENT WHERE accountId = :accountId" ;
		SQLQuery query = sessionFactory.getCurrentSession().createSQLQuery(sql);
		query.setString("accountId", accountId);
		query.setResultTransformer(Transformers.aliasToBean(CarEvent.class));	
		
		@SuppressWarnings("unchecked")
		List<CarInfo> list = query.list();
		if( list == null || list.size() == 0 )
			return false;
		
		return true;
	}



	@Override
	public void updateCarEvent(CarEvent car) {
		sessionFactory.getCurrentSession().update(car);
	}



	@Override
	public void addCarEvent(CarEvent car) {
		sessionFactory.getCurrentSession().save(car);
	}

    

}
