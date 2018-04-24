package com.antiumbo.spcloudportrait.service;


import com.antiumbo.spcloudportrait.web.http.UserReqVo;
import com.antiumbo.tools.http.ResponseVo;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author antiumbo
 */
@FeignClient(name = "user-server")
public interface UserService {
//	ResponseVo test();

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	ResponseVo register(@RequestBody UserReqVo userReqVo);
}
