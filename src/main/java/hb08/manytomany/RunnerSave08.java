package hb08.manytomany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerSave08 {
    public static void main(String[] args) {
        Student08 student1 = new Student08();
        student1.setId(1001);
        student1.setName("Sara");
        student1.setGrade(90);

        Student08 student2 = new Student08();
        student2.setId(1002);
        student2.setName("Cigdem");
        student2.setGrade(97);

        Student08 student3 = new Student08();
        student3.setId(1003);
        student3.setName("Sinan");
        student3.setGrade(90);

        Book08 book1 = new Book08();
        book1.setId(101);
        book1.setName("Math Book");

        Book08 book2 = new Book08();
        book2.setId(102);
        book2.setName("Chemistry Book");

        Book08 book3 = new Book08();
        book3.setId(103);
        book3.setName("Java Book");

        Book08 book4 = new Book08();
        book4.setId(104);
        book4.setName("Hibernate Book");

        Book08 book5 = new Book08();
        book5.setId(105);
        book5.setName("JDBC Book");

        //set books to the students
        student1.getBookList().add(book1);
        student1.getBookList().add(book2);

        student2.getBookList().add(book3);
        student2.getBookList().add(book4);

        student3.getBookList().add(book5);


        //
        // book1.setStudents(student1);






        Configuration con = new Configuration().configure("hibernate.cfg.xml").
                addAnnotatedClass(Student08.class).
                addAnnotatedClass(Book08.class);

        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();

        session.save(student1);
        session.save(student2);
        session.save(student3);

        session.save(book1);
        session.save(book2);
        session.save(book3);
        session.save(book4);
        session.save(book5);



        tx.commit();
        session.close();
        sf.close();


    }

}
