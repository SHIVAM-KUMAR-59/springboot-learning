package org.shivam;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {
        // Creating a Student object to use for saving or updating
        Student s1 = new Student();
        s1.setsName("Kumar");
        s1.setRollNo(102);
        s1.setsAge(19);

        Student s2;

        // Changing age after setting earlier, demonstrating object change
        s1.setsAge(24);

        try {
            // Setting up the Hibernate configuration
            // - Reads hibernate.cfg.xml
            // - Registers the annotated entity class (Student)
            SessionFactory factory = new Configuration()
                    .addAnnotatedClass(org.shivam.Student.class)
                    .configure()
                    .buildSessionFactory();

            // Open a session to interact with the database
            Session session = factory.openSession();

            // =======================
            // RETRIEVE DATA OPERATION
            // =======================

            // Get the Student entity by primary key (roll number)
            // If the record with roll number 101 exists, it will be fetched
            s2 = session.get(Student.class, 101);

            if (s2 == null) {
                System.out.println("Null"); // No record found
            } else {
                System.out.println(s2); // Print the retrieved student
            }

            // ========================
            // DELETE / UPDATE OPERATION
            // ========================

            // Begin a transaction to perform database modification
            Transaction transaction = session.beginTransaction();

            // Option 1: Merge = Insert or Update based on record existence
            // session.merge(s1); // Merges s1 into the database

            // Option 2: Remove = Delete the entity from database
            session.remove(session.get(Student.class, 101)); // Delete student with roll number 101

            // Finalize the transaction (commit the change to DB)
            transaction.commit();

            // ====================
            // RESOURCE CLEAN-UP
            // ====================
            session.clear();  // Clear session cache
            factory.close();  // Close the session factory

        } catch (Exception e) {
            System.out.println("Error inserting data!");
        }
    }
}
