package com.work.api.main.entities;

import javax.persistence.*;
import java.util.Set;


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
    @OneToMany(mappedBy = "user")
    private Set<PhoneBook> books;

    public User()
    {
    }

    public long getId_user()
    {
        return id_user;
    }

    public void setId_user(long id_user)
    {
        this.id_user = id_user;
    }

    public Set<PhoneBook> getBooks()
    {
        return books;
    }

    public void setBooks(Set<PhoneBook> books)
    {
        this.books = books;
    }
}
