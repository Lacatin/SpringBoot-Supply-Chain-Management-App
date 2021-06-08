package com.homework.supplychainmgmt.controller;

import com.homework.supplychainmgmt.dao.OrderItemRepository;
import com.homework.supplychainmgmt.model.Item;
import com.homework.supplychainmgmt.model.OrderItem;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Collection;

@RestController
@AllArgsConstructor
@Slf4j
public class OrderItemController {

    @Autowired
    private OrderItemRepository orderItemRepository;

    @PreAuthorize("hasRole(@roles.ADMIN)")
    @GetMapping(value = "/orderitems/{orderitemsId}", produces = "application/json")
    public OrderItem findOrderItemById(@PathVariable("orderitemsId") int id) throws DataAccessException {
        OrderItem orderItem = orderItemRepository.findOrderItemById(id);
        if (orderItem == null){
            return null;
        }

        return orderItem;
    }

    @PreAuthorize("hasRole(@roles.ADMIN)")
    @GetMapping(value = "/orderitems", produces = "application/json")
    public Collection<OrderItem> findAllOrderItems() throws DataAccessException {
        Collection<OrderItem>orderItems = new ArrayList<>();
        orderItems.addAll(orderItemRepository.findAll());
        if (orderItems.isEmpty()){
            return null;
        }
        return orderItems;
    }

    @PreAuthorize("hasRole(@roles.CLIENT)")
    @PostMapping(value = "/orderitems", consumes = "application/json", produces = "application/json")
    public OrderItem addOrderItem(@RequestBody @Valid OrderItem orderItem){
        return orderItemRepository.save(orderItem);
    }

}
