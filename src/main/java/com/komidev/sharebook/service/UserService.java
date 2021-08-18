package com.komidev.sharebook.service;

import com.komidev.sharebook.entity.User;
import com.komidev.sharebook.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public Iterable<User> getUsers(){
        return repository.findAll();
    }

    public User getUserById(Long id){
        return repository.findById(id).orElse(null);
    }
    public User getUserByUsername(String username){
        return repository.findByUsername(username);
    }

    public User getUserByEmail(String email){
        return repository.findByEmail(email);
    }

    public User save(User user){
        return repository.save(user);
    }

    public void delete(User user){
        repository.delete(user);
    }

    public User delete(Long id){
        User user = this.getUserById(id);
        if(user!=null){
            repository.delete(user);
        }
        return user;
    }

    public User edit(User user){
        return repository.save(user);
    }
}
