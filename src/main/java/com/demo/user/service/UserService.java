package com.demo.user.service;

import com.demo.user.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    String createUser(User user);
    User getUser(int id);
    User updateUser(User user);
    String deleteuser(int id);
    List<User> fetchAllUsers();
}
