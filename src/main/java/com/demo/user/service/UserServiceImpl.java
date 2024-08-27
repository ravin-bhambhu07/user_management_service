package com.demo.user.service;

import com.demo.user.model.User;
import com.demo.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class UserServiceImpl implements UserService  {
    @Autowired
    UserRepository userRepository;

    @Override
    public String createUser(User user) {
        userRepository.save(user);
        return "done";
    }

    @Override
    public User getUser(int id) {
        User user = userRepository.findById(id).orElseThrow(() -> new NoSuchElementException("user not exists!!!"));
        return user;
    }

    @Override
    public User updateUser(User user) {
        User updateduser = userRepository.save(user);
        return updateduser;
    }

    @Override
    public String deleteuser(int id) {
        userRepository.deleteById(id);
        return "deleted";
    }

    @Override
    public List<User> fetchAllUsers() {
      return  userRepository.findAll();
    }

}
