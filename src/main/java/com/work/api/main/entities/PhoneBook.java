package com.work.api.main.entities;

import javax.persistence.*;

/**
 * @author Vsevolod Krupin
 */
@Entity
@Table(name = "phone_book")
public class PhoneBook
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long bookId;

    @Column(name = "phone_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long phoneId;

    @Column(name = "phone")
    private String phone;

    @ManyToOne
    @JoinColumn(columnDefinition = "user_id")
    private User user;

    public PhoneBook(){}

    public long getBookId()
    {
        return bookId;
    }

    public void setBookId(long bookId)
    {
        this.bookId = bookId;
    }

    public long getPhoneId()
    {
        return phoneId;
    }

    public void setPhoneId(long phoneId)
    {
        this.phoneId = phoneId;
    }

    public String getPhone()
    {
        return phone;
    }

    public void setPhone(String phone)
    {
        this.phone = phone;
    }

    public User getUser()
    {
        return user;
    }

    public void setUser(User user)
    {
        this.user = user;
    }
}
