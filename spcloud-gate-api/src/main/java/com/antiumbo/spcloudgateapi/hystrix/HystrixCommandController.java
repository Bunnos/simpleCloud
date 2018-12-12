package com.antiumbo.spcloudgateapi.hystrix;

import com.antiumbo.tools.http.ResponseVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author antiumbo
 * @date on 2018/12/12
 **/
@RestController
public class HystrixCommandController {
    protected final Logger log = LoggerFactory.getLogger(this.getClass());

    @RequestMapping("/hystrixTimeout")
    public ResponseVo hystrixTimeout() {
        log.error("触发了断路由");
        ResponseVo responseVo = ResponseVo.failureResponse("请求失败 from gateway");
        return responseVo;
    }

}
