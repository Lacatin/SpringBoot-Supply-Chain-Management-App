package com.homework.supplychainmgmt.service;

import com.homework.supplychainmgmt.model.Order;
import org.springframework.dao.DataAccessException;
import org.springframework.http.ResponseEntity;

import java.util.Collection;

public interface OrderService {

    Order findOrderById(int id) throws DataAccessException;
    Collection<Order> findAllOrders() throws DataAccessException;
    Collection<Order> findAllMyOrders(int userId) throws DataAccessException;
    Collection<Order> findAllOrdersForMe(int userId) throws DataAccessException;
    Order addOrder(Order order) throws DataAccessException;
    void cancelOrder(int orderId) throws DataAccessException;
    Order setOrderStatus(int id, String status) throws DataAccessException;

}
