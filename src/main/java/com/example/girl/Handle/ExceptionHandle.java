package com.example.girl.Handle;

import com.example.girl.domain.Result;
import com.example.girl.exception.GirlException;
import com.example.girl.utils.ResultUtils;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class ExceptionHandle {
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result handle(Exception e) {
        if (e instanceof GirlException){
            GirlException girlException = (GirlException) e;
            return ResultUtils.error(girlException.getCode(),girlException.getMessage());
        }else{
            return ResultUtils.error(-1, "未知错误");
        }
    }
}
