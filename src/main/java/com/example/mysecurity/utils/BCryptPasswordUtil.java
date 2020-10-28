package com.example.mysecurity.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class BCryptPasswordUtil extends BCryptPasswordEncoder {

    @Override
    public String encode(CharSequence password) {
        return super.encode(password);
    }

    @Override
    public boolean matches(CharSequence password, String encodePassword) {
        return super.matches(password, encodePassword);
    }

}
