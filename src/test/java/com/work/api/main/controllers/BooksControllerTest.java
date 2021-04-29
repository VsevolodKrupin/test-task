package com.work.api.main.controllers;


import com.work.api.main.entities.PhoneBook;
import static org.hamcrest.core.Is.is;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.ClientHttpRequest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.Matchers.hasSize;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.mockito.BDDMockito.given;

@RunWith(SpringRunner.class)
@WebMvcTest(BooksController.class)
public class BooksControllerTest
{
    @Autowired
    private MockMvc mvc;

    @MockBean
    private BooksController booksController;

    @Test
    public void findAllBooks() throws Exception
    {
        List<String> phones = Arrays.asList("123", "2345");
        PhoneBook book = new PhoneBook();
        book.setPhones(phones);
        List<PhoneBook> listOfBooks = new ArrayList<>();
        listOfBooks.add(book);

        given(booksController.findAllBooks()).willReturn(listOfBooks);

        mvc.perform(MockMvcRequestBuilders.get("http://localhost:8080/api/books/get")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].phones", is(book.getPhones())));
    }

    @Test
    public void findBookById() throws Exception
    {
        List<String> phones = Arrays.asList("123", "2345");
        PhoneBook book = new PhoneBook();
        book.setPhones(phones);

        given(booksController.findBookById(book.getBookId())).willReturn(ResponseEntity.ok().body(book));

        mvc.perform(MockMvcRequestBuilders.get("http://localhost:8080/api/books/get/"+book.getBookId())
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("phones", is(book.getPhones())));

    }
}