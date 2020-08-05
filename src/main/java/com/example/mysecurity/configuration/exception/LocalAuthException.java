package com.example.mysecurity.configuration.exception;

import org.springframework.security.core.AuthenticationException;

public class LocalAuthException extends AuthenticationException {
    public LocalAuthException(String msg) {
        super(msg);
    }
}
