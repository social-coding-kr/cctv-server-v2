package com.socialcoding.interfaces.api.base.error;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;
import java.net.BindException;

@Slf4j
@ControllerAdvice
public class ApiControllerAdvice {

    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({IllegalArgumentException.class, BindException.class})
    public RestError resolveArgumentException(HttpServletRequest request, Exception exception) {
        log.error("Parameter exception occurred", exception);

        return RestError.of(HttpStatus.BAD_REQUEST.value(), exception);
    }

    @ResponseBody
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    public RestError resolveException(HttpServletRequest request, Exception exception) {
        log.error("Exception occurred", exception);

		return RestError.of(HttpStatus.INTERNAL_SERVER_ERROR.value(), exception);
    }

}
