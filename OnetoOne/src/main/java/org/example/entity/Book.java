package org.example.entity;
import jakarta.persistence.*;

import org.example.entity.Author;


@Entity
@Table(name = "aadhar")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "Book_number")
    private String book_number;

    @OneToOne(mappedBy = "BookDetails", cascade = CascadeType.ALL)
    private Author author;

    public int getId() {
        return id;
    }

    public String getBookNumber() {
        return book_number;
    }

    public void setBookNumber(String book_number) {
        this.book_number = book_number;
    }

    public Author getPerson() {
        return author;
    }

    public void setPerson(Author person) {
        this.author = person;
    }

    @Override
    public String toString() {
        return "Book { " +
                "id=" + id +
                ", book_number='" + book_number + '\'' +
                ", authorID= " + (author != null ? author.getId() : "null") +
                " }";
    }
}