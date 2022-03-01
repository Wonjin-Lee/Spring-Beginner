package com.wonjin.beginner.study.repository;

import com.wonjin.beginner.study.domain.User;

public interface UserRepository {
    User save(User user);
    int countByUsername(String username);
}
