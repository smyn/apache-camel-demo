package com.cpf.camel.demo.hystraix;

/**
 * @作者：caopengfei
 * @时间：2020/5/28
 */
public class HystrixException  extends RuntimeException{
    public HystrixException() {
    }

    public HystrixException(String message) {
        super(message);
    }

    public HystrixException(String message, Throwable cause) {
        super(message, cause);
    }

    public HystrixException(Throwable cause) {
        super(cause);
    }

    public HystrixException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
