package com.antiumbo.spcloudportrait.service;


import com.antiumbo.spcloudportrait.service.fallback.UserServiceFallback;
import com.antiumbo.spcloudportrait.web.http.UserReqVo;
import com.antiumbo.tools.http.ResponseVo;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author antiumbo
 */
@FeignClient(name = "user-server", fallback = UserServiceFallback.class)
public interface UserService {

	/**
	 * 注册
	 * @param userReqVo
	 * @return
	 */
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	ResponseVo register(@RequestBody UserReqVo userReqVo);
}
