package com.work.api.main.entities;


import com.sun.istack.NotNull;
import com.sun.istack.Nullable;

import javax.persistence.*;
import java.util.List;


/**
 * @author Vsevolod Krupin
 */
@Entity
@Table(name = "user")
public class User
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id_user;

    @NotNull
    private String name;

    @OneToMany(mappedBy = "user")
    @Nullable
    @ElementCollection(targetClass = PhoneBook.class)
    private List<PhoneBook> books;

    public User()
    {
    }

    public User(long id_user, List<PhoneBook> books)
    {
        this.id_user = id_user;
        this.books = books;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public long getId_user()
    {
        return id_user;
    }

    public void setId_user(long id_user)
    {
        this.id_user = id_user;
    }

    public List<PhoneBook> getBooks()
    {
        return books;
    }

    public void setBooks(List<PhoneBook> books)
    {
        this.books = books;
    }
}
