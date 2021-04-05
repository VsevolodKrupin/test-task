package com.work.api.main.entities;

import javax.persistence.*;
import java.util.Set;

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

    @Column(name = "phones")
    @ElementCollection(targetClass=String.class)
    private Set<String> phone;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User user;

    public PhoneBook(){}

    public Set<String> getPhone()
    {
        return phone;
    }

    public void setPhone(Set<String> phone)
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
