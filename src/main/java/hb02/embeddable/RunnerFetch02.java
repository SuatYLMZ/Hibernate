package hb02.embeddable;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerFetch02 {
    public static void main(String[] args) {

        //introducing configuration file and entity class to hibernate
        Configuration con = new Configuration().
                configure("hibernate.cfg.xml").
                addAnnotatedClass(Student02.class);

        SessionFactory sf = con.buildSessionFactory();

        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();

        Student02 student02 = session.get(Student02.class,1002);
        System.out.println(student02);
        System.out.println("------------------------------");
        System.out.println(student02.getAddress());



        tx.commit(); //without commit() data will not be sent to DB
        session.close();
        sf.close();

    }
}
