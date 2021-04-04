package com.work.api.main.controllers;

import com.work.api.main.entities.User;
import com.work.api.main.repos.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * @author Vsevolod Krupin
 */
@RestController
@RequestMapping("/api/users")
public class UserController
{
    @Autowired
    UserRepository userRepository;

    @GetMapping
    public List<User> findAllUsers()
    {
        return (List<User>) userRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> findUserById(@PathVariable(value = "id") long id)
    {
        Optional<User> user = userRepository.findById(id);

        if (user.isPresent())
        {
            return ResponseEntity.ok().body(user.get());
        } else
        {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public User saveUser(@Validated @RequestBody User user){
        return userRepository.save(user);
    }
}
