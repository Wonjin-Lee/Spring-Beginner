package com.wonjin.beginner.study.support;

public interface PasswordEncoder {
    String encode(CharSequence rawPassword);
}
