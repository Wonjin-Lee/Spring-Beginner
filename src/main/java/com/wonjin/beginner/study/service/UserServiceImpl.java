package com.wonjin.beginner.study.service;

import com.wonjin.beginner.study.domain.User;
import com.wonjin.beginner.study.exception.UserAlreadyRegisteredException;
import com.wonjin.beginner.study.repository.UserRepository;
import com.wonjin.beginner.study.support.PasswordEncoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    ApplicationContext context;

    @Override
    public void register(User user, String rawPassword) {
        PasswordEncoder passwordEncoder = passwordEncoder();
        String encodedPassword = passwordEncoder.encode(rawPassword);
    }

    // 룩업 메서드 인젝션을 활용하여 의존 관계 정의
    // 이때 꺼내오는 빈은 원래 의도한 스코프(prototype)대로 설정되어 나온다.
    @Lookup
    PasswordEncoder passwordEncoder() {
        return null;
    }
}
