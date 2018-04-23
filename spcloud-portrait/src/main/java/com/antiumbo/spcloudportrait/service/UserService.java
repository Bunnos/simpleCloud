package com.antiumbo.spcloudportrait.service;


import com.antiumbo.spcloudportrait.web.http.UserReqVo;
import com.antiumbo.tools.http.ResponseVo;

/**
 * @author antiumbo
 */
public interface UserService {
    ResponseVo test();
    ResponseVo register(UserReqVo userReqVo);
}
