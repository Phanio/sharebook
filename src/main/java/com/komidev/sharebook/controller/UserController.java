package com.komidev.sharebook.controller;

import com.komidev.sharebook.entity.User;
import com.komidev.sharebook.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService service;

    @GetMapping
    public Iterable<User> getUsers(){
        return service.getUsers();
    }

    @GetMapping("/{id}")
    public User getUser(@PathVariable Long id){
        return service.getUserById(id);
    }

    @DeleteMapping("/{id}")
    public  User delete(@PathVariable Long id){
        return service.delete(id);
    }

    @PutMapping("/{id}")
    public  User update(@PathVariable Long id, @RequestBody User user){
        user.setId(id);
        return service.edit(user);
    }

}
