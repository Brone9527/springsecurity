package com.example.springsecurity;

import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @Author zeroback13
 * @Date 2021/4/4 11:42
 * @Version 1.0
 */
public class MyPasswordEncoder implements PasswordEncoder {
    @Override
    public String encode(CharSequence charSequence) {
        Md5Password
        return charSequence.toString();
    }

    @Override
    public boolean matches(CharSequence charSequence, String s) {
        return s.equals(charSequence.toString());
    }
}
