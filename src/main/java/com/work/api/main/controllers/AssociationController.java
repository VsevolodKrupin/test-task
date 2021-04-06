package com.work.api.main.controllers;


import com.work.api.main.entities.PhoneBook;
import com.work.api.main.entities.User;
import com.work.api.main.repos.PhoneBookRepository;
import com.work.api.main.repos.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/users/{id}/books")
public class AssociationController
{
    @Autowired
    UserRepository userRepository;

    @Autowired
    PhoneBookRepository phoneBookRepository;

    @PostMapping("/{book_id}")
    public ResponseEntity<User> linkBookById(@PathVariable("id") long id, @PathVariable("book_id") long book_id)
    {
        Optional<User> user = userRepository.findById(id);
        Optional<PhoneBook> phoneBook = phoneBookRepository.findById(book_id);

        if (user.isPresent()&&phoneBook.isPresent())
        {
            user.get().setBook(phoneBook.get());

            return ResponseEntity.ok().body(user.get());
        } else
        {
            return ResponseEntity.notFound().build();
        }
    }
}
