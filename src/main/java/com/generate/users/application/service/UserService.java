package com.generate.users.application.service;

import com.generate.users.application.model.User;
import com.generate.users.database.UserRepository;
import com.generate.users.utils.Generator;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final Generator generator;

    public List<User> getUsers() {
        List<User> users = new ArrayList<>();
        for (User user : userRepository.findAll()) {
            users.add(user);
        }
        return users;
    }

    public User generateUser() {
        User user = generator.generateUser();
        user.setId(1L);
        return user;
    }

    public List<User> generateUserList(Integer count) {
        count = (count > 100) ? 100 : count;
        List<User> users = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            User user = new User();
            Boolean emailCheck = true;
            while (emailCheck) {
                user = generator.generateUser();
                emailCheck = userRepository.existsByEmail(user.getEmail());
            }
            user.setId((long) (i + 1));
            users.add(user);
        }
        return users;
    }

    public Optional<User> getUserById(Integer id) {
        Optional<User> user = userRepository.findById(Long.valueOf(id));
        return user;
    }
}
