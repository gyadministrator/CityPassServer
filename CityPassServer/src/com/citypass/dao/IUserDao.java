package com.citypass.dao;

import com.citypass.vo.User;

public interface IUserDao {
	public User queryToLogin(String account, String password) throws Exception;

	public void save(User user) throws Exception;

}
