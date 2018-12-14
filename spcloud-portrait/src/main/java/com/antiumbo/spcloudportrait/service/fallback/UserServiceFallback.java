package com.antiumbo.spcloudportrait.service.fallback;

import com.antiumbo.spcloudportrait.service.UserService;
import com.antiumbo.spclouduserserver.web.http.UserReqVo;
import com.antiumbo.tools.http.ResponseVo;

/**
 * @author Bran
 * @date 2018/4/25 0025.
 */
public class UserServiceFallback implements UserService {

	@Override
	public ResponseVo register(UserReqVo userReqVo) {
		return null;
	}

	@Override
	public ResponseVo login(UserReqVo userReqVo) {
		return null;
	}
}
