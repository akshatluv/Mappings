package com.example.application.demo.controller;

import com.example.application.demo.Exception.UserNotFoundException;
import com.example.application.demo.UserRequest;
import com.example.application.demo.entity.Address;
import com.example.application.demo.entity.User;
import com.example.application.demo.repo.AddressRepo;
import com.example.application.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    AddressRepo addressRepo;

//    @Value("${server.port:8808}")
//    public String server;

    @GetMapping("/hello")
    public ResponseEntity<String> entry(){
        return new ResponseEntity("hello", HttpStatus.OK);
    }

    @GetMapping("/users")
    public List<User> getAllUser(){
        return userService.getAllUser();
    }

    @GetMapping("/getUserById/{id}")
    public User getUser(@PathVariable long id) throws UserNotFoundException {
        return userService.getUserById(id);
    }

    @PostMapping("/addUsers")
    public User saveUser(@RequestBody UserRequest userRequest){
        return userService.saveUser(userRequest);
    }

    @GetMapping("/address/{city}")
    public User getUserByAddress(@PathVariable String city){
        return this.userService.getUserByAddress(city);
    }

    @PutMapping("/updateUser/{id}")
    public User updateUser(@PathVariable Long id, @RequestBody UserRequest userRequest) throws UserNotFoundException {
        return userService.updateUser(id,userRequest.getUser());
    }
}
