package com.work.api.main.entities;


import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

/**
 * @author Vsevolod Krupin
 */
@Entity
@Table(name = "phone_book")
public class PhoneBook
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long bookId;

    @Column(name = "phones")
    @ElementCollection(targetClass = String.class)
    private List<String> phone;

    @OneToOne(mappedBy = "book")
    private User user;

    public long getBookId()
    {
        return bookId;
    }

    public void setBookId(long bookId)
    {
        this.bookId = bookId;
    }

    public PhoneBook()
    {
    }

    public List<String> getPhone()
    {
        return phone;
    }

    public void setPhone(List<String> phone)
    {
        this.phone = phone;
    }

}
