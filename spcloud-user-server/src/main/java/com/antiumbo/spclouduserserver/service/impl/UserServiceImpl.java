package com.antiumbo.spclouduserserver.service.impl;

import com.antiumbo.spclouduserserver.config.redis.RedisUtil;
import com.antiumbo.spclouduserserver.dao.UserDao;
import com.antiumbo.spclouduserserver.model.UserModel;
import com.antiumbo.spclouduserserver.service.IUserService;
import com.antiumbo.spclouduserserver.web.http.UserReqVo;
import com.antiumbo.tools.exception.BusinessException;
import com.antiumbo.tools.password.PasswordUtil;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.UUID;

/**
 * @author antiumbo
 * @date on 2018/12/12
 **/
@Service
public class UserServiceImpl implements IUserService {
    public static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
    @Autowired
    private UserDao userDao;
    @Autowired
    private RedisUtil redisUtil;
    private final long EXPIRE_SECONDS = 3600;

    @Override
    public String register(UserReqVo userReqVo) throws BusinessException {
        logger.info("inter register method, userReqVo:{}", userReqVo.toString());
        UserModel userModel = new UserModel();
        userModel.setName(userReqVo.getName());
        userModel.setPassword(PasswordUtil.encode(userReqVo.getPassword()));
        userModel.setCreateDate(new Date());
        UserModel userModelByName = userDao.findUserModelByName(userReqVo.getName());
        if (userModelByName != null) {
            throw BusinessException.newException("用户名已存在！");
        }
        userDao.save(userModel);
        String token = String.valueOf(UUID.randomUUID()).replace("-", "");
        // 将token放入缓存中
        redisUtil.set(token, userModel.getId(), EXPIRE_SECONDS);
        return token;
    }

    @Override
    public String login(UserReqVo userReqVo) throws BusinessException {
        String token = null;
        UserModel userModel;
        if (userReqVo != null) {
            String name = userReqVo.getName();
            String pwd = userReqVo.getPassword();
            if (StringUtils.isEmpty(name) || StringUtils.isEmpty(pwd)) {
                throw BusinessException.newException("用户名或密码为空");
            }
            String newPwd = PasswordUtil.encode(pwd);
            userModel = userDao.findByNameAndPassword(name, newPwd);
            if (userModel != null) {
                token = String.valueOf(UUID.randomUUID()).replace("-", "");
            } else {
                throw BusinessException.newException("用户名或密码错误");
            }
            // 将token放入缓存中
            redisUtil.set(token, userModel.getId(), EXPIRE_SECONDS);
        }
        return token;
    }

    @Override
    public UserModel getUserInfo(Integer userId) throws Exception {
        if (userId == null || userId == 0) {
            throw new BusinessException("token失效");
        }
        UserModel userModel = userDao.getUserById(userId);
        return userModel;
    }
}
