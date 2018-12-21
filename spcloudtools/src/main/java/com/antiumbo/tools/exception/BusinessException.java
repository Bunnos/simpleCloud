package com.antiumbo.tools.exception;

/**
 * @author antiumbo
 * @date on 2018/12/12
 **/
public final class BusinessException extends RuntimeException {
    private static final long serialVersionUID = 1721891525581654383L;
    private final int code = -3;
    private Object data;

    public BusinessException(String msg) {
        super(msg);
        this.data = msg;
    }

    public static BusinessException newException(String msg) {
        return new BusinessException(msg);
    }
}
