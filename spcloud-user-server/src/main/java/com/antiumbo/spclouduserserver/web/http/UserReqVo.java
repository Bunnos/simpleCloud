package com.antiumbo.spclouduserserver.web.http;

import lombok.Data;

import java.io.Serializable;

/**
 * @author Bran
 * @date 2018/4/23 0023.
 */
@Data
public class UserReqVo implements Serializable {
    private static final long serialVersionUID = -4333316296251054416L;

    private String name;
    private String password;
}
