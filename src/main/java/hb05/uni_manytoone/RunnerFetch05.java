package hb05.uni_manytoone;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;


public class RunnerFetch05 {
    public static void main(String[] args) {

        Configuration con = new Configuration().
                configure("hibernate.cfg.xml");
//                addAnnotatedClass(Student05.class).addAnnotatedClass(University.class);

        SessionFactory sf = con.buildSessionFactory();

        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();

        //get method

        Student05 student1 = session.get(Student05.class, 1001);
        System.out.println(student1);

        University university = session.get(University.class, 101);
        System.out.println(university);

        //using student1 obj we can reach to university
        System.out.println(student1.getUniversity());

        //fetch students whose univ id is 101 using hql
        System.out.println("••••••••••• whose univ id is 101••••••••••••");
        String hql1 = "FROM Student05 s WHERE s.university.id = 101";
        List<Student05> studentsList = session.createQuery(hql1, Student05.class).getResultList();

        studentsList.forEach(s-> System.out.println(s));


        tx.commit();
        session.close();
        sf.close();
    }
}
