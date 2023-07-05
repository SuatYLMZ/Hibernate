package hb02.embeddable;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerSave02 {
    public static void main(String[] args) {
        //create student object
        Student02 student01 = new Student02();
        student01.setName("Aykut");
        student01.setId(1001);
        student01.setGrade(90);

        Student02 student02 = new Student02();
        student02.setName("Fatih");
        student02.setId(1002);
        student02.setGrade(95);

        Student02 student03 = new Student02();
        student03.setName("Sara");
        student03.setId(1003);
        student03.setGrade(85);

        Student02 student04 = new Student02();
        student04.setName("Sinan");
        student04.setId(1004);
        student04.setGrade(99);

        //create address object
        Address address1 = new Address();
        address1.setCity("New York");
        address1.setCountry("USA");
        address1.setStreet("Hello Street");
        address1.setZipCode("3545");

        Address address2 = new Address();
        address2.setCity("Texas");
        address2.setCountry("USA");
        address2.setStreet("hibernate Street");
        address2.setZipCode("4567");

        student01.setAddress(address1);
        student02.setAddress(address2);
        student03.setAddress(address2);
        student04.setAddress(address1);

        //introducing configuration file and entity class to hibernate
        Configuration con = new Configuration().
                configure("hibernate.cfg.xml").
                addAnnotatedClass(Student02.class);

        SessionFactory sf = con.buildSessionFactory();

        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();

        session.save(student01);
        session.save(student02);
        session.save(student03);
        session.save(student04);

        tx.commit(); //without commit() data will not be sent to DB
        session.close();
        sf.close();

    }
}
