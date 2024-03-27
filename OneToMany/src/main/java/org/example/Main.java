package org.example;
import org.example.configuration.HibernateUtils;
import org.example.entity.Policy;
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

        List<Policy> list = new ArrayList<>();

        Policy policy1 = new Policy();
        policy1.setInsuranceNumber(32423497L);
        policy1.setInsuranceType("Life Insurance");
        policy1.setDeposit(200000.0);
        list.add(policy1);

        Policy policy2 = new Policy();
        policy2.setInsuranceNumber(36799753L);
        list.add(policy2);

        policy1.setPerson(p1);
        policy1.setPerson(p1);
        p1.setPolicyDetail(list);

        SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        session.persist(p1);

        session.getTransaction().commit();

        System.out.println("Printing from person -: ");
        Person savedPerson = session.get(Person.class, 1L);
        System.out.println(savedPerson);

        System.out.println("Printing from Policy -: ");
        Policy savedAccount = session.get(Policy.class, 1L);
        System.out.println(savedAccount);

        Policy savedAccount2 = session.get(Policy.class, 2L);
        System.out.println(savedAccount2);

        session.close();
    }
}
