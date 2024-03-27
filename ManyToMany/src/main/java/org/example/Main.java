package org.example;
import org.example.configuration.HibernateUtils;
import org.example.entity.Actor;
import org.example.entity.Movie;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.*;
public class Main
{
    public static void main( String[] args )
    {

        System.out.println("Working");

        Actor ac1 = new Actor();
        ac1.setfName("Shahrukh");
        ac1.setlName("Khan");
        ac1.setEmail("srk@gmail.com");

        Actor ac2 = new Actor();
        ac2.setfName("Aayushman");
        ac2.setlName("Khurana");
        ac2.setEmail("ayushmann@gmail.com");

        List<Actor> actor = new ArrayList<>();
        actor.add(ac1);
        actor.add(ac2);

        Movie m1 = new Movie();
        m1.setName("Spiderman 3");
        m1.setGenre("Action");

        Movie m2 = new Movie();
        m2.setName("Avatar 2");
        m2.setGenre("Thriller");

        List<Movie> movies = new ArrayList<>();
        movies.add(m1);
        movies.add(m2);

        ac1.setMovie(movies);
        ac2.setMovie(movies);

        m1.setActor(actor);
        m2.setActor(actor);




        SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        session.persist(ac1);
        session.persist(ac2);
        session.persist(m1);
        session.persist(m2);

        session.getTransaction().commit();

        System.out.println("Printing from Actor -: ");
        Actor savedActor1 = session.get(Actor.class, 1L);
        System.out.println(savedActor1);

        Actor savedActor2 = session.get(Actor.class, 2L);
        System.out.println(savedActor2);

        System.out.println("Printing from Movies -: ");
        Movie savedMovie1 = session.get(Movie.class, 1L);
        System.out.println(savedMovie1);

        Movie savedMovie2 = session.get(Movie.class, 2L);
        System.out.println(savedMovie2);

        session.close();
    }
}
