package com.antiumbo.spcloudportrait.web.user;

import com.antiumbo.spcloudportrait.service.UserService;
import com.antiumbo.spcloudportrait.web.http.UserReqVo;
import com.antiumbo.tools.http.ResponseVo;
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

/**
 * @author antiumbo
 */
@Api("用户")
@RestController
public class UserController {
	private final Logger logger = LoggerFactory.getLogger(UserController.class);
	@Autowired
	private UserService userService;

	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public ResponseVo test() {
		ResponseVo test = userService.test();
		return test;
	}

	@ApiOperation(value = "注册", notes = "注册用户")
	@ApiImplicitParam(name = "userReqVo", value = "用户注册请求实体类", required = true, dataType = "UserReqVo")
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ResponseVo register(@RequestBody UserReqVo userReqVo) {
		try {
			ResponseVo responseVo = userService.register(userReqVo);
			return responseVo;
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
			return ResponseVo.failureResponse();
		}
	}
}
