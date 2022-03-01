package com.wonjin.beginner.study.bean;

import com.wonjin.beginner.study.repository.UserRepository;
import com.wonjin.beginner.study.repository.UserRepositoryImpl;
import com.wonjin.beginner.study.service.UserService;
import com.wonjin.beginner.study.service.UserServiceImpl;
import com.wonjin.beginner.study.support.BCryptPasswordEncoder;
import com.wonjin.beginner.study.support.PasswordEncoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.wonjin.beginner")
public class AppConfig {
    @Bean
    UserRepository userRepository() {
        return new UserRepositoryImpl();
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    UserService userService() {
        // 매개변수로 컴포넌트의 의존성 주입
        return new UserServiceImpl(userRepository(), passwordEncoder());
    }
}
