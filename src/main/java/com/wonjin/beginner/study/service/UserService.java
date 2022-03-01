package com.wonjin.beginner.study.service;

import com.wonjin.beginner.study.domain.User;

public interface UserService {
    void register(User user, String rawPassword);
}
