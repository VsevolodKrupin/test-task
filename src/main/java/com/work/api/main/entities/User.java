package com.work.api.main.entities;


import com.sun.istack.NotNull;
import com.sun.istack.Nullable;

import javax.persistence.*;


/**
 * @author Vsevolod Krupin
 */
@Entity
@Table(name = "user")
public class User
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_user;

    @NotNull
    private String name;

    @Nullable
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "bookId", referencedColumnName = "bookId")
    private PhoneBook book;

    public User()
    {
    }

    public User(long id_user, String name, PhoneBook book)
    {
        this.id_user = id_user;
        this.name = name;
        this.book = book;
    }

    public PhoneBook getBook()
    {
        return book;
    }

    public void setBook(PhoneBook book)
    {
        this.book = book;
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

}
