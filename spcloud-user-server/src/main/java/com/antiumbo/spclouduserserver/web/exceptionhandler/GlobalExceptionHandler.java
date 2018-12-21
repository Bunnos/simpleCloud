package com.antiumbo.spclouduserserver.web.exceptionhandler;

import com.antiumbo.tools.exception.BusinessException;
import com.antiumbo.tools.http.ResponseVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author antiumbo
 * @date on 2018/12/18
 **/
@ControllerAdvice
public class GlobalExceptionHandler {
    public static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    /**
     * 系统错误
     *
     * @param e
     * @return
     */
    @ResponseBody
    @ExceptionHandler(value = Exception.class)
    public ResponseVo systemException(Exception e) {
        logger.info("系统错误");
        return ResponseVo.failureResponse(e.getMessage());
    }

    /**
     * 自定义错误
     *
     * @param e
     * @return
     */
    @ResponseBody
    @ExceptionHandler(value = BusinessException.class)
    public ResponseVo businessException(BusinessException e) {
        logger.info("自定义错误");
        return ResponseVo.failureResponse(e.getMessage());
    }
}
