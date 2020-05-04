package com.lant.springboot_basic_use.exception;

import com.lant.springboot_basic_use.enums.ResultCode;
import com.lant.springboot_basic_use.vo.ResultVo;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * Created by xiaomo
 */
@RestControllerAdvice
public class BizExceptionHandler {

    /**
     * 用于处理参数校验异常
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResultVo bindException(MethodArgumentNotValidException e) {
        BindingResult bindingResult = e.getBindingResult();
        ResultVo resultVo = new ResultVo();
        resultVo.setCode(ResultCode.RESULT_VALID_REQUST_ERRO);
        //返回主要错误信息
        resultVo.setMessage(bindingResult.getFieldErrors().get(0).getDefaultMessage());
        return resultVo;
    }
}
