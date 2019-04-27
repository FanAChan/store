package com.achan.common;

/**
 * @author AChan
 * @title: StoreException
 * @date 2019/4/19
 */
public class StoreException extends Exception {

    private String state;

    private String message;

    public StoreException() {
        super();
    }

    public StoreException(String state, String message) {
        super();
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
