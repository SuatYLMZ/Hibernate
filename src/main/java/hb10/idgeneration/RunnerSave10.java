package hb10.idgeneration;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.io.Serializable;

public class RunnerSave10 {
    public static void main(String[] args) {

        Student10 student1 =  new Student10();
        student1.setName("AAA");
        student1.setGrade(99);

        Student10 student2 =  new Student10();
        student2.setName("BBB");
        student2.setGrade(88);


        Configuration con = new Configuration().
                configure("hibernate.cfg.xml").
                addAnnotatedClass(Student10.class);


        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();



        // Serializable returnID = session.save(student1); //returns id as Serializable
        session.persist(student2);



        tx.commit();
        session.close();
        sf.close();

    }

}
