package com.antiumbo.spcloudportrait.config.aspect;

import com.antiumbo.spcloudportrait.config.redis.RedisUtil;
import com.antiumbo.spcloudportrait.utils.UserUtil;
import com.antiumbo.tools.exception.BusinessException;
import org.apache.commons.lang.StringUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * @author antiumbo
 * @date on 2018/12/21
 **/
@Aspect
@Component
public class TokenAspect {
    public static final Logger logger = LoggerFactory.getLogger(TokenAspect.class);
    @Autowired
    private RedisUtil redisUtil;
    @Autowired
    private UserUtil userUtil;

    @Pointcut("@annotation(com.antiumbo.spcloudportrait.config.aspect.TokenAuth)")
    public void executeService() {
    }

    @Around("executeService()")
    public Object tokenAuth(ProceedingJoinPoint pjp) throws Throwable {
        RequestAttributes ra = RequestContextHolder.getRequestAttributes();
        ServletRequestAttributes sra = (ServletRequestAttributes) ra;
        HttpServletRequest request = sra.getRequest();
        String token = request.getHeader("token");
        logger.info("token:{}", token);
        if (StringUtils.isEmpty(token)) {
            return BusinessException.newException("token不能为空");
        }
        Integer userId = (Integer) redisUtil.get(token);
        if (userId == null) {
            throw BusinessException.newException("无效的token");
        }
        userUtil.setUserId(userId);
        Object proceed = pjp.proceed();
        return proceed;
    }
}
