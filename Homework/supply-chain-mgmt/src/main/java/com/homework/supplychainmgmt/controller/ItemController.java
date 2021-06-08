package com.homework.supplychainmgmt.controller;

import com.homework.supplychainmgmt.dao.ItemRepository;
import com.homework.supplychainmgmt.model.Item;

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
public class ItemController {

    @Autowired
    private ItemRepository itemRepository;

    @PreAuthorize("hasRole(@roles.ADMIN)")
    @GetMapping(value = "/items/{itemId}", produces = "application/json")
    public Item findItemById(@PathVariable("itemId") int id) throws DataAccessException {
        Item item = itemRepository.findItemById(id);
        if (item == null){
            return null;
        }

        return item;
    }

    @PreAuthorize("hasRole(@roles.ADMIN)")
    @GetMapping(value = "/items", produces = "application/json")
    public Collection<Item> findAllItems() throws DataAccessException {
        Collection<Item>items = new ArrayList<>();
        items.addAll(itemRepository.findAll());
        if (items.isEmpty()){
            return null;
        }
        return items;
    }

    @PreAuthorize("hasRole(@roles.MANUFACTURER)")
    @PostMapping(value = "/items", consumes = "application/json", produces = "application/json")
    public Item addItem(@RequestBody @Valid Item item){
        return itemRepository.save(item);
    }

    @PreAuthorize("hasRole(@roles.MANUFACTURER)")
    @DeleteMapping(value = "/items/{itemId}", produces = "application/json")
    @Transactional
    public void deleteItem(@PathVariable("itemId") int itemId){
        itemRepository.deleteById(itemId);
    }
}
