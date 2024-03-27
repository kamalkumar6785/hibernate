package org.example;

import org.example.configuration.HibernateUtils;
import org.example.entity.Office;
import org.example.entity.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import java.util.*;

public class Main
{
    public static void main( String[] args )
    {

        Person p1 = new Person();
        p1.setFname("Kamal");
        p1.setLname("Kumar");
        p1.setEmail("kamal.kumar@gmail.com");

        List<Office> list = new ArrayList<>();

        Office of1 = new Office();
        of1.setBuildingNumber("A2");
        of1.setLocality("Sector 58");
        of1.setCity("Gurugram");
        of1.setState("Haryana");
        of1.setPinCode("121010");
        list.add(of1);

        Office of2 = new Office();
        of2.setBuildingNumber("A1");
        of2.setLocality("Sector 51");
        of2.setCity("Noida");
        of2.setState("Uttar Pradesh");
        of2.setPinCode("242010");
        list.add(of2);

        of1.setPerson(p1);
        of1.setPerson(p1);
        p1.setPersonOffice(list);

        SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        session.persist(p1);

        session.getTransaction().commit();

        System.out.println("Printing from person  :");
        Person savedPerson = session.get(Person.class, 1L);
        System.out.println(savedPerson);

        System.out.println("Printing from Office  :");
        Office savedOffice1 = session.get(Office.class, 1L);
        System.out.println(savedOffice1);

        Office savedOffice2 = session.get(Office.class, 2L);
        System.out.println(savedOffice2);

        session.close();
    }
}
