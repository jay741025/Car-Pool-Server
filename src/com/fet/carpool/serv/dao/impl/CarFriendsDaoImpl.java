package com.fet.carpool.serv.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.fet.carpool.serv.dao.BaseDao;
import com.fet.carpool.serv.dao.CarFriendsDao;

import com.fet.carpool.serv.persistence.CarFriends;




@Repository("carFriendsDao")
public class CarFriendsDaoImpl extends BaseDao implements CarFriendsDao {

    @Autowired
    private SessionFactory sessionFactory;

    

	

	@SuppressWarnings("unchecked")
	@Override
	public List<CarFriends> findCarFriendsByAccountId(String accountId) {
		Criteria crit = sessionFactory.getCurrentSession().createCriteria(
				CarFriends.class);
        crit.add(Restrictions.eq("accountId", accountId));
        List<CarFriends> result = crit.list();
        if( result!=null && result.size() > 0 )
            return result;
        return null;
	}



	@Override
	public void addFriends(CarFriends carFriends) {
		sessionFactory.getCurrentSession().save(carFriends);
	}



	@SuppressWarnings("unchecked")
	@Override
	public CarFriends findCarFriendsById(String accountId,
			String friendsId) {
		Criteria crit = sessionFactory.getCurrentSession().createCriteria(
				CarFriends.class);
        crit.add(Restrictions.eq("accountId", accountId));
        crit.add(Restrictions.eq("friendsId", friendsId));
        List<CarFriends> result = crit.list();
        if( result!=null && result.size() > 0 )
            return result.get(0);
        return null;
	}

    

}
