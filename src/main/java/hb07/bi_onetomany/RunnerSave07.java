package hb07.bi_onetomany;

import hb06.uni_onetomany.Book06;
import hb06.uni_onetomany.Student06;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerSave07 {
    public static void main(String[] args) {

        //student07 obj using parameter
        Student07 student1 = new Student07(1001, "Cigdem", 89);

        //student07 obj using empty constructor
        Student07 student2 = new Student07();

        student2.setId(1002);
        student2.setName("Marian");
        student2.setGrade(90);


        //book objects
        Book07 book1 = new Book07();
        book1.setId(101);
        book1.setName("Math Book");

        Book07 book2 = new Book07();
        book2.setId(102);
        book2.setName("Chemistry Book");

        Book07 book3 = new Book07();
        book3.setId(103);
        book3.setName("Physics Book");

        //set books to student class
        //when we use mappedBy, the owner of relation will be books side
//        student1.getBookList().add(book1);
//        student1.getBookList().add(book2);


        //set student to book
        book1.setStudent(student1);
        book2.setStudent(student1);

        book3.setStudent(student2);


        Configuration con = new Configuration().configure("hibernate.cfg.xml").
                addAnnotatedClass(Student07.class).
                addAnnotatedClass(Book07.class);

        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();

        session.save(student1);
        session.save(student2);

        session.save(book1);
        session.save(book2);
        session.save(book3);



        tx.commit();
        session.close();
        sf.close();

    }
}
