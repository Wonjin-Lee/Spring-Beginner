package com.wonjin.beginner.study.service;

import com.wonjin.beginner.study.domain.User;
import com.wonjin.beginner.study.exception.UserAlreadyRegisteredException;
import com.wonjin.beginner.study.repository.UserRepository;
import com.wonjin.beginner.study.support.PasswordEncoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    @Qualifier("sha256PasswordEncoder")
    private PasswordEncoder passwordEncoder;

    @Override
    public void register(User user, String rawPassword) {
        if (this.userRepository.countByUsername(user.getUsername()) > 0) {
            throw new UserAlreadyRegisteredException();
        }

        user.setPassword(this.passwordEncoder.encode(rawPassword));
        this.userRepository.save(user);
    }
}
