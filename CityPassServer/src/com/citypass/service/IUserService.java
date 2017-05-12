package com.citypass.service;

import com.citypass.result.Result;
import com.citypass.vo.User;

public interface IUserService {
	public Result<User> queryToLogin(User user) throws Exception;

	public Result<Boolean> register(User user) throws Exception;
}
