package com.achan.common;

import java.util.Map;

/**
 * @author AChan
 * @title: CommonResponse
 * @date 2019/4/19
 */
public class CommonResponse {

    /**
     * 返回状态码，默认0为成功
     */
    private int status = 0;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    private boolean success;

    private String message;

    private Map<String, Object> data;

    public CommonResponse() {
        super();
    }

    public CommonResponse(boolean success, String message, Map<String, Object> data) {
        super();
        this.setSuccess(success);
        this.setMessage(message);
        this.setData(data);
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Map<String, Object> getData() {
        return data;
    }

    public void setData(Map<String, Object> data) {
        this.data = data;
    }


    /**
     * 操作失败
     *
     * @param
     * @return com.achan.common.CommonResponse
     * @Author AChan
     * @Date 2019/4/22 0:53
     **/
    public static CommonResponse operationFailed() {
        return new CommonResponse(false, Constants.OPERATION_FAILED, null);
    }

    /**
     * 自定义失败提示
     *
     * @param message
     * @return com.achan.common.CommonResponse
     * @Author AChan
     * @Date 2019/4/22 0:53
     **/
    public static CommonResponse operationFailed(String message) {
        return new CommonResponse(false, message, null);
    }

    /**
     * 操作成功
     *
     * @param
     * @return com.achan.common.CommonResponse
     * @Author AChan
     * @Date 2019/4/22 0:54
     **/
    public static CommonResponse operationSuccess() {
        return new CommonResponse(true, Constants.OPERATION_SUCCESS, null);
    }

    /**
     * 自定义操作成功提示
     *
     * @param message
     * @return com.achan.common.CommonResponse
     * @Author AChan
     * @Date 2019/4/22 0:54
     **/
    public static CommonResponse operationSuccess(String message) {
        return new CommonResponse(true, message, null);
    }

    public static CommonResponse success(Map<String, Object> data) {
        return new CommonResponse(true, Constants.OPERATION_SUCCESS, data);
    }

}
