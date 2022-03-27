package com.wonjin.beginner.study.bean;

import com.wonjin.beginner.study.repository.UserRepository;
import com.wonjin.beginner.study.repository.UserRepositoryImpl;
import com.wonjin.beginner.study.service.UserService;
import com.wonjin.beginner.study.service.UserServiceImpl;
import com.wonjin.beginner.study.support.BCryptPasswordEncoder;
import com.wonjin.beginner.study.support.PasswordEncoder;
import com.wonjin.beginner.study.support.Sha256PasswordEncoder;
import com.wonjin.beginner.study.support.ThreadUnsafePasswordEncoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
@ComponentScan("com.wonjin.beginner")
public class AppConfig {
    @Bean
    UserRepository userRepository() {
        return new UserRepositoryImpl();
    }

    @Bean
    @Scope("prototype")
    UserService userService() {
        return new UserServiceImpl();
    }

    @Bean
    @Scope("prototype")
    PasswordEncoder passwordEncoder() {
        // 멀티 스레드 환경에서 안전하지 않으므로 singleton으로 사용하면 안 됨
        return new ThreadUnsafePasswordEncoder();
    }
}
