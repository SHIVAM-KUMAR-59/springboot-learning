package org.shivam;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

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
        l1.setLid(1);
        l1.setBrand("Asus");
        l1.setModel("Rog");
        l1.setRam(16);

        Alien a1 = new Alien();
        a1.setAid(101);
        a1.setAname("First");
        a1.setTech("Java");
        a1.setLaptop(l1);

        Transaction transaction = session.beginTransaction();

        session.persist(l1);
        session.persist(a1);

        transaction.commit();

        Alien a2 = session.get(Alien.class, 101);
        System.out.println(a2);

        session.clear();
        factory.close();
    }
}