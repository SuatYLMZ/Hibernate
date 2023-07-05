package hb06.uni_onetomany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.awt.print.Book;
import java.util.Arrays;
import java.util.List;

public class RunnerFetch06 {
    public static void main(String[] args) {
        Configuration con = new Configuration().configure("hibernate.cfg.xml").
                addAnnotatedClass(Student06.class).
                addAnnotatedClass(Book06.class);

        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();


//        System.out.println("******* fetch student using get() *******");
//        Student06 std1 = session.get(Student06.class, 1001);
//        System.out.println(std1);

//        System.out.println("******* fetch book with id 101 using HQL *******");
//        String bookHQL = "FROM Book06 WHERE id=101";
//        Book06 book1 = session.createQuery(bookHQL, Book06.class).uniqueResult();
//        System.out.println(book1);

        System.out.println("******* fetch books of student whose id 1001 using HQL *******");
        String hqlQuery2 = "SELECT b.id, b.name FROM Student06 s INNER JOIN s.bookList b WHERE s.id = 1001 ";
        List<Object[]> resultList1 = session.createQuery(hqlQuery2).getResultList();
        resultList1.forEach(obj-> System.out.println(Arrays.toString(obj)));

        System.out.println("******* fetch books of student whose id 1001 using get() *******");
        Student06 std3 = session.get(Student06.class, 1001);
        System.out.println(std3.getBookList());

        tx.commit();
        session.close();
        sf.close();
    }
}
