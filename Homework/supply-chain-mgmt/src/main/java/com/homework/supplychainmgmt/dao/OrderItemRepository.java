package com.homework.supplychainmgmt.dao;

import com.homework.supplychainmgmt.model.Order;
import com.homework.supplychainmgmt.model.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem, Integer> {

    OrderItem findOrderItemById(int id);
}
