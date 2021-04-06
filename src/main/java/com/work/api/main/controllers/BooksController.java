package com.work.api.main.controllers;


import com.work.api.main.entities.PhoneBook;
import com.work.api.main.repos.PhoneBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/books")
public class BooksController
{
    @Autowired
    PhoneBookRepository phoneBookRepository;

    @GetMapping("/get")
    public List<PhoneBook> findAllBooks()
    {
        return (List<PhoneBook>) phoneBookRepository.findAll();
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<PhoneBook> findBookById(@PathVariable(value = "id") long id)
    {
        Optional<PhoneBook> book = phoneBookRepository.findById(id);

        if (book.isPresent())
        {
            return ResponseEntity.ok().body(book.get());
        } else
        {
            return ResponseEntity.notFound().build();
        }

    }

    @PostMapping("/save")
    public PhoneBook savePhoneBook(@Validated @RequestBody PhoneBook phoneBook)
    {
        return phoneBookRepository.save(phoneBook);
    }

    @PostMapping("/edit/{id}")
    public ResponseEntity<PhoneBook> editPhoneBook(@PathVariable(value = "id") long id, @Validated @RequestBody PhoneBook phoneBook)
    {
        Optional<PhoneBook> bookToEdit = phoneBookRepository.findById(id);

        if (bookToEdit.isPresent())
        {
            bookToEdit.get().setPhone(phoneBook.getPhone());

            return ResponseEntity.ok().body(bookToEdit.get());
        } else
        {
            return ResponseEntity.notFound().build();
        }
    }

}
