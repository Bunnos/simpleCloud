package com.antiumbo.spclouduserserver.web;

import com.antiumbo.spclouduserserver.dao.UserDao;
import com.antiumbo.spclouduserserver.model.UserModel;
import com.antiumbo.spclouduserserver.web.http.UserReqVo;
import com.antiumbo.tools.http.ResponseVo;
import com.antiumbo.tools.password.PasswordUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;


/**
 * @author antiumbo
 */
@Api("用户")
@RestController
public class UserController {
	private final Logger logger = LoggerFactory.getLogger(UserController.class);
	@Autowired
	private UserDao userDao;

	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public String test() throws Exception {
		System.out.println("nihao");
		throw new Exception("nihao");
	}

	@ApiOperation(value = "注册", notes = "注册用户")
	@ApiImplicitParam(name = "userReqVo", value = "用户注册请求实体类", required = true, dataType = "UserReqVo")
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ResponseVo register(@RequestBody UserReqVo userReqVo) {
		UserModel userModel = new UserModel();
		userModel.setName(userReqVo.getName());
		userModel.setPassword(PasswordUtil.encode(userReqVo.getPassword()));
		UserModel userModelByName = userDao.findUserModelByName(userReqVo.getName());
		if (userModelByName != null) {
			return ResponseVo.failureResponse("用户名已存在！");
		}
		userDao.save(userModel);
		String token = String.valueOf(UUID.randomUUID()).replace("-", "");
		return ResponseVo.successResponse("token", token);
	}

	@ApiOperation(value = "登录", notes = "用户登录")
	@ApiImplicitParam(name = "reqVo", value = "用户登陆请求实体类", required = true, dataType = "UserReqVo")
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ResponseVo login(@RequestBody UserReqVo reqVo) {
		ResponseVo responseVo = null;
		return responseVo;
	}
}
