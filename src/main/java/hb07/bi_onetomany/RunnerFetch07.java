package hb07.bi_onetomany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Arrays;
import java.util.List;

public class RunnerFetch07 {
    public static void main(String[] args) {
        Configuration con = new Configuration().configure("hibernate.cfg.xml").
                addAnnotatedClass(Student07.class).
                addAnnotatedClass(Book07.class);

        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();

        Student07 student1 = session.get(Student07.class, 1001);
//        System.out.println(student1);

        //using student obj, get books
//        student1.getBookList().forEach(std-> System.out.println(std));
//
//        Book07 book1 =  session.get(Book07.class, 101);
//        System.out.println("Book 1: "+ book1);
        //using book, get student obj
//        System.out.println(book1.getStudent());

        //fetch student name and book name using SQL from student

        String sqlQuery1 = "SELECT s.std_name, b.name FROM t_student07 s INNER JOIN t_book07 b ON s.id = b.std_id";

        List<Object[]>  resultList1 =  session.createSQLQuery(sqlQuery1).getResultList();
        resultList1.forEach(obj-> System.out.println(Arrays.toString(obj)));

        //// using HQL query, fetch  name of book and student from students who has book

        String hqlQuery2 = "SELECT s.name, b.name FROM Student07 s INNER  JOIN  Book07 b ON s.id = b.student.id";

        List<Object[]> resultList2 = session.createQuery(hqlQuery2).getResultList();
        for(Object[] obj: resultList2){
            System.out.println(Arrays.toString(obj));
        }


        // DELETE records from Book07 using SQL

        String sqlQuery2= "DELETE FROM t_book07";

        int numberOFDeletedRecords = session.createSQLQuery(sqlQuery2).executeUpdate();

        System.out.println("numberOFDeletedRecords : "+numberOFDeletedRecords);//5


        // DELETE records from Student07 using SQL

        String sqlQuery3= "DELETE FROM t_student07";

        int numberOFDeletedRecords1 = session.createSQLQuery(sqlQuery3).executeUpdate();

        System.out.println("numberOFDeletedRecords1 : "+numberOFDeletedRecords1);//3



        // DELETE records from Student07 using HQL

        String hqlQuery4= "DELETE FROM Student07";

        int numberOFDeletedRecords2 = session.createQuery(hqlQuery4).executeUpdate();
        System.out.println("numberOFDeletedRecords2 : "+numberOFDeletedRecords2);//3

        // DELETE records from Book07 using HQL

//        String hqlQuery5= "DELETE FROM Book07";
//
//        int numberOFDeletedRecords3 = session.createQuery(hqlQuery5).executeUpdate();
//        System.out.println("numberOFDeletedRecords3 : "+numberOFDeletedRecords3);//3



        // Delete Book records which name as "Art Book " using hql

        String hqlQuery6= "DELETE FROM Book07 b WHERE b.name ='Art Book'";
        int numberOFDeletedRecords6 = session.createQuery(hqlQuery6).executeUpdate();
        System.out.println("numberOFDeletedRecords6 : "+numberOFDeletedRecords6);



        // delete student object with get method() id 1001
        // remove with cascade
//         Student07 std = session.get(Student07.class,1001);
//       // System.out.println(std.getBookList());
//          session.delete(std);

        // remove with OrphanRemove
//          Student07 std2 = session.get(Student07.class,1002);
//          std2.getBookList().set(0,null);

        // write a HQL query which will  bring students whose book name has word "java";

        String hqlQuery= "SELECT s FROM Student07 s JOIN s.bookList b  WHERE b.name LIKE '%Book%' ";

        List<Student07> resultList =  session.createQuery(hqlQuery,Student07.class).getResultList();

        for(Student07 std:resultList){
            System.out.println(std);
        }





        tx.commit();
        session.close();
        sf.close();
    }
}
