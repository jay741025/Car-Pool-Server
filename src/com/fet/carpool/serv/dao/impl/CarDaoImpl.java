package com.fet.carpool.serv.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.fet.carpool.serv.dao.BaseDao;
import com.fet.carpool.serv.dao.CarDao;

import com.fet.carpool.serv.persistence.Car;




@Repository("carDao")
public class CarDaoImpl extends BaseDao implements CarDao {

    @Autowired
    private SessionFactory sessionFactory;

    @SuppressWarnings("unchecked")
	@Override
	public List<Car> list() {		
		Criteria crit = sessionFactory.getCurrentSession().createCriteria(
				Car.class);
        crit.add(Restrictions.eq("status", 1));
        List<Car> result = crit.list();
        if( result.size() > 0 )
            return result;
        return null;
	}

	

	@SuppressWarnings("unchecked")
	@Override
	public Car findCarByAccountId(String accountId) {
		Criteria crit = sessionFactory.getCurrentSession().createCriteria(
				Car.class);
        crit.add(Restrictions.eq("accountId", accountId));
        List<Car> result = crit.list();
        if( result.size() > 0 )
            return result.get(0);
        return null;
	}



	@Override
	public void updateCarInfo(Car car) {
		sessionFactory.getCurrentSession().update(car);
	}



	@Override
	public void addCarInfo(Car car) {
		sessionFactory.getCurrentSession().save(car);
	}

    

}
