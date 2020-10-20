package com.example.mysecurity.auth.exception;

import org.springframework.security.core.AuthenticationException;

public class LocalAuthenticationException extends AuthenticationException {
    public LocalAuthenticationException(String msg) {
        super(msg);
    }
}
