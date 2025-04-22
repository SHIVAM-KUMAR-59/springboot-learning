package org.shivam;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {
        Student s1 = new Student();
        s1.setsName("Kumar");
        s1.setRollNo(102);
        s1.setsAge(19);

        try{

            /*
            Configuration cfg = new Configuration();
            cfg.addAnnotatedClass(org.shivam.Student.class);
            cfg.configure();

            // Session factory is a very heavy package
            // SessionFactory factory = cfg.buildSessionFactory();
            
             */
            SessionFactory factory = new Configuration().addAnnotatedClass(org.shivam.Student.class).configure().buildSessionFactory();
            Session session = factory.openSession();

            Transaction transaction = session.beginTransaction();

            session.persist(s1);

            transaction.commit();

            session.clear();
            factory.close();

        }catch(Exception e){
            System.out.println("Error inserting data!");
        }

        System.out.println(s1);
    }
}