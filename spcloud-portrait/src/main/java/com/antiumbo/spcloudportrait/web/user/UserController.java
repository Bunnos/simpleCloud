package com.antiumbo.spcloudportrait.web.user;

import com.antiumbo.spcloudportrait.config.aspect.TokenAuth;
import com.antiumbo.spcloudportrait.config.redis.RedisUtil;
import com.antiumbo.spcloudportrait.service.UserService;
import com.antiumbo.spclouduserserver.web.http.UserReqVo;
import com.antiumbo.tools.http.ResponseVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;



/**
 * @author antiumbo
 */
@Api(value = "用户", description = "用户模块")
@RequestMapping("/user")
@RestController
public class UserController {
    private final Logger logger = LoggerFactory.getLogger(UserController.class);
    @Autowired
    private UserService userService;
    @Autowired
    private RedisUtil redisUtil;

    @ApiOperation(value = "用户注册", notes = "用户注册")
    @ApiImplicitParam(name = "userReqVo", value = "用户注册请求实体类", required = true, dataType = "UserReqVo")
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ResponseVo register(@RequestBody UserReqVo userReqVo) {
        logger.info("enter register method, userReqVo:{}", userReqVo.toString());
        ResponseVo responseVo = userService.register(userReqVo);
        return responseVo;
    }

    @ApiOperation(value = "用户登录", notes = "用户登录")
    @ApiImplicitParam(name = "userReqVo", value = "用户注册请求实体类", required = true, dataType = "UserReqVo")
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseVo login(@RequestBody UserReqVo userReqVo) {
        logger.info("enter login method, userReqVo:{}", userReqVo.toString());
        ResponseVo responseVo = userService.login(userReqVo);
        return responseVo;
    }

    @TokenAuth
    @ApiOperation(value = "查询用户信息", notes = "查询用户信息")
    @ApiImplicitParam(name = "token", value = "token", required = true, paramType = "query", dataType = "string")
    @GetMapping(value = "/getUserInfo")
    public ResponseVo getUserInfo(@RequestParam String token) {
        Integer id = (Integer) redisUtil.get(token);
        ResponseVo responseVo = userService.getUserInfo(id);
        return responseVo;
    }
}
