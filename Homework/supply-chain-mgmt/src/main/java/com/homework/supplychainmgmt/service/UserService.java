package com.homework.supplychainmgmt.service;

import com.homework.supplychainmgmt.model.User;

import java.util.Collection;

public interface UserService {

    void saveUser(User user) throws Exception;
    Collection<User> findAllUsers() throws Exception;
}
