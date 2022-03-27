package com.wonjin.beginner.study.service;

import com.wonjin.beginner.study.domain.User;
import com.wonjin.beginner.study.exception.UserAlreadyRegisteredException;
import com.wonjin.beginner.study.repository.UserRepository;
import com.wonjin.beginner.study.support.PasswordEncoder;
import org.springframework.beans.factory.annotation.Autowired;
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

    // ApplicationContext를 통해 DI 컨테이너에 등록된 빈을 직접 찾아서 가져온다.
    // 이때 꺼내오는 빈은 원래 의도한 스코프(prototype)대로 설정되어 나온다.
    PasswordEncoder passwordEncoder() {
        return this.context.getBean(PasswordEncoder.class);
    }
}
