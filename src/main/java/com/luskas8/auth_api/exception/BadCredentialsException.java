package com.luskas8.auth_api.exception;

import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.UNAUTHORIZED)
public class BadCredentialsException extends AuthenticationException {
    public BadCredentialsException(String msg) {
        super(msg);
    }
}
