package com.homework.supplychainmgmt.service;

import com.homework.supplychainmgmt.model.Order;
import com.homework.supplychainmgmt.model.User;
import org.springframework.dao.DataAccessException;

import java.util.Collection;

public interface SupplyChainManagementService {

    User findUserById(int id) throws DataAccessException;
    Collection<User> findAllUsers() throws DataAccessException;
    void saveUser(User user) throws DataAccessException;
    void deleteUser(User user) throws DataAccessException;

    Order findOrderById(int id) throws DataAccessException;
    Collection<Order> findAllOrders() throws DataAccessException;
    void newOrder(int id) throws DataAccessException;
    void cancelOrder(int orderId, int clientId) throws DataAccessException;


}
