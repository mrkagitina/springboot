package com.example.demo3.service;

import com.example.demo3.model.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();
    void createUser(User user);
    void updateUser(User user);
    void deleteUser(Long id);
    User findUser(Long id);
}
