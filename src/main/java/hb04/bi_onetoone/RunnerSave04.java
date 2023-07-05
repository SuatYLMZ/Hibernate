package hb04.bi_onetoone;

import hb03.uni_onetoone.Dairy;
import hb03.uni_onetoone.Student03;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerSave04 {
    public static void main(String[] args) {

        Student04 student1= new Student04();
        student1.setId(1001);
        student1.setName("AAA");
        student1.setGrade(99);

        Student04 student2= new Student04();
        student2.setId(1002);
        student2.setName("BBB");
        student2.setGrade(88);

        Student04 student3= new Student04();
        student3.setId(1003);
        student3.setName("CCC");
        student3.setGrade(95);

        // create Dairy object

        Dairy04 dairy1 = new Dairy04();
        dairy1.setId(101);
        dairy1.setName("AAA's dairy");

        Dairy04 dairy2 = new Dairy04();
        dairy2.setId(102);
        dairy2.setName("BBB's dairy");

        Dairy04 dairy3 = new Dairy04();
        dairy3.setId(103);
        dairy3.setName("CCC's dairy");

        //set
        dairy1.setStudent(student1);
        dairy2.setStudent(student2);
        //  dairy3.setStudent(student3);

        //dairy1.setStudent(student2);




        Configuration con = new Configuration().
                configure("hibernate.cfg.xml").
                addAnnotatedClass(Student04.class)
                .addAnnotatedClass(Dairy04.class);

        SessionFactory sf = con.buildSessionFactory();

        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();

        //save student
        session.save(student1);
        session.save(student2);
        session.save(student3);

        // save dairy object

        session.save(dairy1);
        session.save(dairy2);
        session.save(dairy3);



        tx.commit(); //without commit() data will not be sent to DB
        session.close();
        sf.close();

    }
}
