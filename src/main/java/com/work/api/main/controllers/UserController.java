package com.work.api.main.controllers;


import com.work.api.main.entities.User;
import com.work.api.main.repos.PhoneBookRepository;
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

    @Autowired
    PhoneBookRepository phoneBookRepository;

    @GetMapping("/get")
    public List<User> findAllUsers()
    {
        return (List<User>) userRepository.findAll();
    }

    @GetMapping("/get/{id}")
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

    @PostMapping("/save")
    public User saveUser(@Validated @RequestBody User user)
    {
        user.setBook(phoneBookRepository.findById(user.getBook().getBookId()).get());
        return userRepository.save(user);
    }

    @PostMapping("/edit/{id}")
    public ResponseEntity<User> editUser(@PathVariable(value = "id") long id, @Validated @RequestBody User user)
    {
        Optional<User> userToEdit = userRepository.findById(id);

        if (userToEdit.isPresent())
        {
            userToEdit.get().setBook(user.getBook());
            userToEdit.get().setName(user.getName());
            return ResponseEntity.ok().body(userToEdit.get());
        } else
        {
            return ResponseEntity.notFound().build();
        }
    }
}
