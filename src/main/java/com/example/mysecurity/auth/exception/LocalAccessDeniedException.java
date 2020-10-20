package com.example.mysecurity.auth.exception;

import org.springframework.security.access.AccessDeniedException;

public class LocalAccessDeniedException extends AccessDeniedException {


    public LocalAccessDeniedException(String msg) {
        super(msg);
    }
}
