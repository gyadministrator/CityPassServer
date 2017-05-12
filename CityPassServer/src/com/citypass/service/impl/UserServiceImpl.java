package com.citypass.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.citypass.dao.IUserDao;
import com.citypass.result.Result;
import com.citypass.service.IUserService;
import com.citypass.vo.User;

@Service
public class UserServiceImpl implements IUserService {
	private IUserDao userDao;

	@Resource(name = "userDaoImpl")
	public void setUserDao(IUserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public Result<User> queryToLogin(User user) throws Exception {
		User u = userDao.queryToLogin(user.getAccount(), user.getPassword());
		Result<User> result = new Result<>();
		if (u != null) {
			result.state = result.STATE_SUCCESS;
			result.description = "登录成功";
			result.data = u;
		} else {
			result.state = result.STATE_FAILURE;
			result.description = "用户不存在";
		}
		return result;
	}

	@Override
	public Result<Boolean> register(User user) {
		Result<Boolean> result = new Result<>();
		try {
			
			userDao.save(user);
			result.state = result.STATE_SUCCESS;
			result.description = "注册成功";
			result.data = true;
		} catch (Exception e) {
			result.state = result.STATE_FAILURE;
			result.description = "注册失败";
			result.data = false;
			e.printStackTrace();
		}
		return result;
	}
}
