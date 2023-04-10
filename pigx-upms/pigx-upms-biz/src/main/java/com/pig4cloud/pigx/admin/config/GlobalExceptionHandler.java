package com.pig4cloud.pigx.admin.config;

import com.pig4cloud.pigx.common.core.util.R;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

/**
 * @author DC
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * 控制层校验
     *
     * @param methodArgumentNotValidException
     * @return
     * @throws Exception
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public R<?> exceptionHandler(MethodArgumentNotValidException methodArgumentNotValidException) throws Exception {
        List<FieldError> fieldErrors = methodArgumentNotValidException.getBindingResult().getFieldErrors();
        StringBuilder message = new StringBuilder();
        for (int i = 0; i < fieldErrors.size(); i++) {
            message.append(fieldErrors.get(i).getDefaultMessage());
            if (i < fieldErrors.size() - 1) {
                message.append(",");
            }
        }
        return R.failed(message);
    }

    /**
     * 全局异常拦截
     */
    @ExceptionHandler(value =Exception.class)
    @ResponseBody
    public R<?> exceptionHandler(Exception e){
        return  R.failed(false,e.getMessage());
    }
}
