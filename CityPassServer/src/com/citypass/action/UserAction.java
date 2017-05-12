package com.citypass.action;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.citypass.base.BaseAction;
import com.citypass.result.Result;
import com.citypass.service.IUserService;
import com.citypass.vo.User;

@Controller
@Scope(value = "prototype")
public class UserAction extends BaseAction {
	private User user;
	private IUserService userService;

	@Resource(name = "userServiceImpl")
	public void setUserService(IUserService userService) {
		this.userService = userService;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public void login() throws Exception {
		user.setAccount(new String(user.getAccount().getBytes("ISO-8859-1"),
				"utf-8"));
		Result<User> result = userService.queryToLogin(user);
		print(result, "password");
	}

	public void register() throws Exception {
		user.setAccount(new String(user.getAccount().getBytes("ISO-8859-1"),
				"utf-8"));
		Result<Boolean> result = userService.register(user);
		print(result);
	}

}
