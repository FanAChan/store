package com.achan.common;


import com.achan.common.CommonResponse;
import com.achan.common.StoreException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author AChan
 * @title: StoreExceptionHandler
 * @date 2019/4/19
 */
@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public CommonResponse handler(Exception e) {
        e.printStackTrace();
        if (e instanceof StoreException) {
            return CommonResponse.operationFailed(e.getMessage());
        }
        return CommonResponse.operationFailed("系统异常");
    }
}
