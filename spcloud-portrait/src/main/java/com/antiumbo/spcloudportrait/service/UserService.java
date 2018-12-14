package com.antiumbo.spcloudportrait.service;


import com.antiumbo.spcloudportrait.service.fallback.UserServiceFallback;
import com.antiumbo.spclouduserserver.web.http.UserReqVo;
import com.antiumbo.tools.http.ResponseVo;
import org.springframework.cloud.openfeign.FeignClient;
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
     *
     * @param userReqVo
     * @return
     */
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    ResponseVo register(@RequestBody UserReqVo userReqVo);

    /**
     * 登录
     *
     * @param userReqVo
     * @return
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    ResponseVo login(@RequestBody UserReqVo userReqVo);
}
