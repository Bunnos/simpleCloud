/*
package com.antiumbo.spcloudportrait.service.impl;

import com.antiumbo.spcloudportrait.service.UserService;
import com.antiumbo.spcloudportrait.web.http.UserReqVo;
import com.antiumbo.tools.http.ResponseVo;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


*/
/**
 * @author antiumbo
 *//*

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private RestTemplate restTemplate;

	@Override
	@HystrixCommand(fallbackMethod = "userFallback")
	public ResponseVo test() {
		return null;
	}

	@Override
	@HystrixCommand(fallbackMethod = "userFallback")
	public ResponseVo register(UserReqVo userReqVo) {
		UserReqVo reqVo = new UserReqVo();
		reqVo.setName(userReqVo.getName());
		reqVo.setPassword(userReqVo.getPassword());
		ResponseVo post = restTemplate.postForObject("http://user-server/register", reqVo, ResponseVo.class);
		return post;
	}

	public ResponseVo userFallback(UserReqVo userReqVo) {
		return null;
	}
}
*/
