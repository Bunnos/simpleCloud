package com.antiumbo.spclouduserserver.web;

import com.antiumbo.spclouduserserver.model.UserModel;
import com.antiumbo.spclouduserserver.service.IUserService;
import com.antiumbo.spclouduserserver.web.http.UserReqVo;
import com.antiumbo.tools.http.ResponseVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * @author antiumbo
 */
@RestController
public class UserController {
    private final Logger logger = LoggerFactory.getLogger(UserController.class);
    @Autowired
    private IUserService userService;

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ResponseVo register(@RequestBody UserReqVo userReqVo) throws Exception {
        logger.info("enter user-service register method, userReqVo:{}", userReqVo.toString());
        String token = userService.register(userReqVo);
        return ResponseVo.successResponse("token", token);
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseVo login(@RequestBody UserReqVo userReqVo) throws Exception {
        logger.info("enter user-service login method, userReqVo:{}", userReqVo.toString());
        String token = userService.login(userReqVo);
        return ResponseVo.successResponse("token", token);
    }

    @RequestMapping(value = "/getUserInfo", method = RequestMethod.GET)
    public ResponseVo getUserInfo(Integer userId) throws Exception {
        UserModel model = userService.getUserInfo(userId);
        return ResponseVo.successResponse("model", model);
    }
}
