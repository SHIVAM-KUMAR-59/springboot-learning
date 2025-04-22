package org.shivam;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {
        Student s1 = new Student();
        s1.setsName("Shivam");
        s1.setRollNo(101);
        s1.setsAge(19);

        try{
            Configuration cfg = new Configuration();
            SessionFactory factory = cfg.buildSessionFactory();
            Session session = factory.openSession();
            session.save(s1);
        }catch(Exception e){
            e.printStackTrace();
        }

        System.out.println(s1);
    }
}