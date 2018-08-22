package com.monk.sbbook.error;

import com.monk.sbbook.result.pojo.JsonResult;
import com.monk.sbbook.result.pojo.Result;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;

/**
 * 全局错误拦截器，不过开启@ResponseBody会导致rg.springframework.web.HttpMediaTypeNotAcceptableException: Could not find acceptable representation
 * 开启拦截@ControllerAdvice会导致其他错误，有空再研究
 */
//@ControllerAdvice
//@ResponseBody
public class GlobalExceptionHandler {

    @ExceptionHandler(value = Exception.class)
//    @ResponseBody
//    @ResponseStatus
    public Result defaultErrorHandler(HttpServletRequest req, Exception e) throws Exception {
        return JsonResult.genFailResult("服务器出错啦");
    }

}
