package hb04.bi_onetoone;

import hb03.uni_onetoone.Dairy;
import hb03.uni_onetoone.Student03;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Arrays;
import java.util.List;

public class   RunnerFetch04 {
    public static void main(String[] args) {

        //introducing configuration file and entity class to hibernate
        Configuration con = new Configuration().
                configure("hibernate.cfg.xml").
                addAnnotatedClass(Student04.class).addAnnotatedClass(Dairy04.class);

        SessionFactory sf = con.buildSessionFactory();

        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();

        // get student and dairy by Id using  get method

//        Student04 student1 =  session.get(Student04.class,1001);
//        System.out.println(student1);
//        System.out.println("------------------------");
//        Dairy04 dairy1 =  session.get(Dairy04.class,101);
//        System.out.println(dairy1);
//        System.out.println("******** get diary object over student ***********");
//        System.out.println(student1.getDairy());
//
//        System.out.println("******** get student object over diary ***********");
//        System.out.println(dairy1.getStudent());
//        System.out.println("******** get student name through diary obj ********");
//        System.out.println(dairy1.getStudent().getName());

        System.out.println("********** INNER JOIN **********");
        String hql1 = "SELECT s.name, d.name FROM Student04 s INNER JOIN FETCH Dairy04 d ON s.id = d.student.id";

        List<Object[]> resultList1 = session.createQuery(hql1).getResultList();

        resultList1.forEach(obj-> System.out.println(Arrays.toString(obj)));


        System.out.println("********** LEFT JOIN **********");
        String hql2 = "SELECT s.name, d.name FROM Student04 s LEFT JOIN FETCH Dairy04 d ON s.id = d.student.id";

        //sql version of above query
        //"SELECT s.std_name, d.name FROM t_student04 s LEFT JOIN t_dairy04 d ON s.id = d.student.id"

        List<Object[]> resultList2 = session.createQuery(hql2).getResultList();

        resultList2.forEach(obj-> System.out.println(Arrays.toString(obj)));

        System.out.println("********** RIGHT JOIN **********");
        String hql3 = "SELECT s.name, d.name FROM Student04 s RIGHT JOIN FETCH Dairy04 d ON s.id = d.student.id";



        List<Object[]> resultList3 = session.createQuery(hql3).getResultList();

        resultList3.forEach(obj-> System.out.println(Arrays.toString(obj)));


        System.out.println("********** FULL JOIN **********");
        String hql4 = "SELECT s.name, d.name FROM Student04 s FULL JOIN FETCH Dairy04 d ON s.id = d.student.id";

        List<Object[]> resultList4 = session.createQuery(hql4).getResultList();

        resultList4.forEach(obj-> System.out.println(Arrays.toString(obj)));


        tx.commit(); //without commit() data will not be sent to DB
        session.close();
        sf.close();
    }
}
