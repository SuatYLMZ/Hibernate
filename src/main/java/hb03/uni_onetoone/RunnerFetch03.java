package hb03.uni_onetoone;

import hb02.embeddable.Student02;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class  RunnerFetch03 {
    public static void main(String[] args) {

        //introducing configuration file and entity class to hibernate
        Configuration con = new Configuration().
                configure("hibernate.cfg.xml").
                addAnnotatedClass(Student03.class).addAnnotatedClass(Dairy.class);

        SessionFactory sf = con.buildSessionFactory();

        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();

        System.out.println("************** using get() fetch Students*************");
        Student03 student1=  session.get(Student03.class,1001);
        System.out.println(student1);


        System.out.println("************** using get() fetch dairy*************");

        Dairy dairy1=  session.get(Dairy.class ,101);
        System.out.println(dairy1);

        System.out.println("************** using get() fetch student from dairy  *************");
        System.out.println(dairy1.getStudent());





        tx.commit(); //without commit() data will not be sent to DB
        session.close();
        sf.close();
    }
}
