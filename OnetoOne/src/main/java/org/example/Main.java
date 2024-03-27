package org.example;

import org.example.configuration.HibernateUtils;
import org.example.entity.Book;
import org.example.entity.Author;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class Main
{
    public static void main( String[] args )
    {
        Author p1 = new Author();
        p1.setFname("JK");
        p1.setLname("Rowling");
        p1.setEmail("jkrowling@gmail.com");

        Book a1 = new Book();
        a1.setBookNumber("1234567");

        a1.setPerson(p1);
        p1.setBookDetails(a1);

        SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        session.persist(p1);

        session.getTransaction().commit();

        System.out.println("Printing from Author: ");
        Author savedPerson = session.get(Author.class, 1);
        System.out.println(savedPerson);

        System.out.println("Printing from Books ");
        Book savedBook = session.get(Book.class, 1);
        System.out.println(savedBook);

        session.close();
    }
}