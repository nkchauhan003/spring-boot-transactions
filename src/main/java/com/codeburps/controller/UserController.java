package com.codeburps.controller;

import com.codeburps.dto.UserDto;
import com.codeburps.model.User;
import com.codeburps.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/")
    public User addUser(@RequestBody UserDto userDto) {
        return userRepository.save(new User(userDto.getWalletAmount()));
    }
}
