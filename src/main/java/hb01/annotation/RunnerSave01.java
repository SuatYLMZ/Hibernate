package hb01.annotation;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

//this class is used to store objects to database
public class RunnerSave01 {
    public static void main(String[] args) {
        //Create objects from Student01 class
        Student01 student1 = new Student01();
        student1.setId(1001);
        student1.setName("Cigdem");
        student1.setGrade(99);

        Student01 student2 = new Student01();
        student2.setId(1002);
        student2.setName("Marian");
        student2.setGrade(98);

        Student01 student3 = new Student01();
        student3.setId(1003);
        student3.setName("Yusuf");
        student3.setGrade(95);



        //introducing configuration file and entity class to hibernate
        Configuration con = new Configuration().
                configure("hibernate.cfg.xml").
                addAnnotatedClass(Student01.class);

        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();

        //session.save(student1);
        //session.save(student2);
        session.save(student3);


        tx.commit(); //without commit() data will not be sent to DB
        session.close();
        sf.close();
    }
}
