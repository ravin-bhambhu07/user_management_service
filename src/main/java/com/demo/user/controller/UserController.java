package com.demo.user.controller;

import com.demo.user.model.User;
import com.demo.user.model.response.CustomResponse;
import com.demo.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/create")
    public ResponseEntity<CustomResponse<String>> createUser(@RequestBody User user){
        String response = userService.createUser(user);
        CustomResponse<String> resp = new CustomResponse<String>("user Created Successfully!!",response);
        return ResponseEntity.status(HttpStatus.OK).body(resp);
    }

    @GetMapping("/fetch/{id}")
    public ResponseEntity<CustomResponse<User>> getUser(@PathVariable("id") int id){
       User user = userService.getUser(id);
       CustomResponse<User> resp = new CustomResponse<User>("user fetched successfully!!",user);
       return ResponseEntity.status(HttpStatus.OK).body(resp);
    }

    @PutMapping("/update")
    public User updateUser(@RequestBody User user){
        User updatedUser = userService.updateUser(user);
        return updatedUser;
    }

    @DeleteMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") int id){
        return userService.deleteuser(id);
    }

    @GetMapping("/")
    public List<User> fetchAllUsers(){
        return userService.fetchAllUsers();
    }
}
