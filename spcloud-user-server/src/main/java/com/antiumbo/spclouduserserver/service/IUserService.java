package com.antiumbo.spclouduserserver.service;

import com.antiumbo.spclouduserserver.model.UserModel;
import com.antiumbo.spclouduserserver.web.http.UserReqVo;

import javax.servlet.http.HttpServletRequest;

/**
 * @author antiumbo
 * @date on 2018/12/12
 **/
public interface IUserService {
    /**
     * 注册
     *
     * @param userReqVo
     * @return
     * @throws Exception
     */
    String register(UserReqVo userReqVo) throws Exception;

    /**
     * 登录
     *
     * @param userReqVo
     * @return
     * @throws Exception
     */
    String login(UserReqVo userReqVo) throws Exception;

    /**
     * 获取用户信息
     *
     * @param id
     * @return
     * @throws Exception
     */
    UserModel getUserInfo(Integer id) throws Exception;
}
