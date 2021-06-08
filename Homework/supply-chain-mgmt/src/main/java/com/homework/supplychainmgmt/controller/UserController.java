package com.homework.supplychainmgmt.controller;

import com.homework.supplychainmgmt.dao.UserRepository;
import com.homework.supplychainmgmt.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@RestController
@Slf4j
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @ResponseBody
    @PreAuthorize( "hasRole(@roles.ADMIN)" )
    @PostMapping(value = "/users", consumes = "application/json", produces = "application/json")
    public User addUser(@RequestBody  User user) throws Exception {
        return userRepository.save(user);
    }

    @PreAuthorize( "hasRole(@roles.ADMIN)" )
    @GetMapping(value = "/users", produces = "application/json")
    public List<User> findAllUsers() throws Exception {
        return  userRepository.findAll();

    }

    @PreAuthorize( "hasRole(@roles.CLIENT)" )
    @DeleteMapping(value = "/users/{userId}", produces = "application/json")
    void deleteUser(@PathVariable("userId") int userId, Authentication auth){
        User user = userRepository.findUserByUsername(auth.getName());
        if (user.getId() == userId) {
            userRepository.deleteById(userId);
        }
    }

}
