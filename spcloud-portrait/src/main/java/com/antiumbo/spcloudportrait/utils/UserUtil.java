package com.antiumbo.spcloudportrait.utils;


import lombok.Data;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

/**
 * @author antiumbo
 * @date on 2018/12/24
 **/
@Data
@Component
@Scope(value = "request",proxyMode = ScopedProxyMode.TARGET_CLASS)
public class UserUtil {
    private Integer userId;
}
