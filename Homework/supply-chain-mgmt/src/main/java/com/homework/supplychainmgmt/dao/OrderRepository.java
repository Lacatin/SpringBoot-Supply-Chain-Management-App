package com.homework.supplychainmgmt.dao;

import com.homework.supplychainmgmt.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Optional;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {

    Order findOrderById(int id);
    void  deleteOrderById(int id);
    Collection<Order>findOrdersByClientId(int id);
    Collection<Order>findOrdersByManufacturerId(int id);
}
