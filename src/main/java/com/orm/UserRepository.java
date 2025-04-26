package com.orm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class UserRepository {

	@Autowired
	private HibernateTemplate temp;
	
	@Transactional
	public int CreateUser(User user) {
				int id = (Integer)	temp.save(user);
				return id;
	}
}
 