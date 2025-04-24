package org.shivam;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        /*
        Student s1 = new Student();
        s1.setsName("Kumar");
        s1.setRollNo(102);
        s1.setsAge(19);

        Student s2 = null;

        s1.setsAge(24);

        try{

            ------------------------------------------
            Configuration cfg = new Configuration();
            cfg.addAnnotatedClass(org.shivam.Student.class);
            cfg.configure();

            // Session factory is a very heavy package
            // SessionFactory factory = cfg.buildSessionFactory();

             ------------------------------------------

            SessionFactory factory = new Configuration().addAnnotatedClass(org.shivam.Student.class).configure().buildSessionFactory();
            Session session = factory.openSession();

            ------------------------------------------
            Required only when we are doing some operation like updation or creation
            Transaction transaction = session.beginTransaction();

            session.persist(s1); // Saves the data

            transaction.commit(); // Commit so that the db gets updated

            ------------------------------------------

            s2 = session.get(Student.class, 101); // Type and value of primary key

            if(s2 == null){
                System.out.println("Null");
            }else{
                System.out.println(s2);
            }

            // Use transaction to perform update oprations
            Transaction transaction = session.beginTransaction();

            // session.merge(s1); // Merge change the data in the database (if data is not there, it creates it)
            // System.out.println(s1);

            session.remove(session.get(Student.class, 101)); // Delete an object
            transaction.commit();

            session.clear();
            factory.close();

        }catch(Exception e){
            System.out.println("Error inserting data!");
        }

         */

        SessionFactory factory = new Configuration().addAnnotatedClass(org.shivam.Alien.class).addAnnotatedClass(org.shivam.Laptop.class).configure().buildSessionFactory();
        Session session = factory.openSession();

        Laptop l1 = new Laptop();
        l1.setLid(4);
        l1.setBrand("Asus");
        l1.setModel("Strix");
        l1.setRam(32);

        /*
        Laptop l2 = new Laptop();
        l2.setLid(2);
        l2.setBrand("Dell");
        l2.setModel("XPS");
        l2.setRam(32);

        Laptop l3 = new Laptop();
        l2.setLid(3);
        l2.setBrand("Lenovo");
        l2.setModel("Thinkbook");
        l2.setRam(16);

        Alien a1 = new Alien();
        a1.setAid(101);
        a1.setAname("First");
        a1.setTech("Java");

        Alien a2 = new Alien();
        a2.setAid(102);
        a2.setAname("Second");
        a2.setTech("Java");


        a1.setLaptops(Arrays.asList(l1, l2));
        a2.setLaptops(Arrays.asList(l3));
        */

        // Transaction transaction = session.beginTransaction();

        // session.persist(l1);
        /*
        session.persist(l2);
        session.persist(l3);
        session.persist(a1);
        session.persist(a2);
         */

        // SQL --> select * from Laptop where ram = 32;
        // HQL --> from Laptop where ram = 32;

        Query query = session.createQuery("from Laptop where ram=32");
        List<Laptop> laptops = query.getResultList();

        // Laptop l5 = session.get(Laptop.class, 4);
        System.out.println(laptops);


        // transaction.commit();

        // Alien a5 = session.get(Alien.class, 101);
        // System.out.println(a5);

        session.clear();
        factory.close();
    }
}