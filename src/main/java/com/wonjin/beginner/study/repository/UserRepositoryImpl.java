package com.wonjin.beginner.study.repository;

import com.wonjin.beginner.study.domain.User;
import org.springframework.stereotype.Component;

@Component
public class UserRepositoryImpl implements UserRepository {
    @Override
    public User save(User user) {
        return null;
    }

    @Override
    public int countByUsername(String username) {
        return 0;
    }
}
