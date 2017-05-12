package com.citypass.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.citypass.base.BaseDao;
import com.citypass.dao.IUserDao;
import com.citypass.vo.User;

@Component
public class UserDaoImpl extends BaseDao<User> implements IUserDao {
	@Autowired
	public UserDaoImpl(HibernateTemplate hibernateTemplate) {
		super.setHibernateTemplate(hibernateTemplate);
	}

	@Override
	public User queryToLogin(String account, String password) throws Exception {
		String hql = "from User where account=? and password=?";
		User user = queryEntity(hql, account, password);
		return user;
	}

	@Override
	public void save(User user) throws Exception {
		super.save(user);
	}

}
