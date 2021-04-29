package com.work.api.main.entities;


import javax.persistence.*;
import java.util.List;

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
    private List<String> phones;

    @OneToOne(mappedBy = "book")
    private User user;

    public PhoneBook()
    {

    }

    public PhoneBook(List<String> phones)
    {
        this.phones = phones;
    }

    public long getBookId()
    {
        return bookId;
    }

    public void setBookId(long bookId)
    {
        this.bookId = bookId;
    }

    public List<String> getPhones()
    {
        return phones;
    }

    public void setPhones(List<String> phones)
    {
        this.phones = phones;
    }

}
