package com.wonjin.beginner.study.service;

import com.wonjin.beginner.study.domain.User;
import com.wonjin.beginner.study.exception.UserAlreadyRegisteredException;
import com.wonjin.beginner.study.repository.UserRepository;
import com.wonjin.beginner.study.support.PasswordEncoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void register(User user, String rawPassword) {
        if (this.userRepository.countByUsername(user.getUsername()) > 0) {
            throw new UserAlreadyRegisteredException();
        }

        user.setPassword(this.passwordEncoder.encode(rawPassword));
        this.userRepository.save(user);
    }
}
