package com.wonjin.beginner.study.bean;

import com.wonjin.beginner.study.repository.UserRepository;
import com.wonjin.beginner.study.repository.UserRepositoryImpl;
import com.wonjin.beginner.study.service.UserService;
import com.wonjin.beginner.study.service.UserServiceImpl;
import com.wonjin.beginner.study.support.BCryptPasswordEncoder;
import com.wonjin.beginner.study.support.PasswordEncoder;
import com.wonjin.beginner.study.support.Sha256PasswordEncoder;
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
    PasswordEncoder bcryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean(name = "lightweight")
    PasswordEncoder sha256PasswordEncoder() {
        return new Sha256PasswordEncoder();
    }

    @Bean
    @Scope("prototype")
    UserService userService() {
        return new UserServiceImpl();
    }
}
