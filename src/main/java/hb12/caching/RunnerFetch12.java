package hb12.caching;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/*
    1) First level Cache --->
            * default caching, can not be closed
            * caches in the same session
            * memory is cleared when session is closed
     2) Second level Cache --->
            * closed by default (needs to be enabled manually)
            * caches in Session Factory level (can cache in different sessions)
     3) Query Cache
            * Used for queries
            *needs to be enabled manually
 */

public class RunnerFetch12 {
    public static void main(String[] args) {
        Configuration con = new Configuration().
                configure("hibernate.cfg.xml").
                addAnnotatedClass(Student12.class);


        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();

        System.out.println("first get method for  student whose ID is 1L");
        Student12 student1 = session.get(Student12.class, 1L);

        //session.clear(); //it clears cache memory

        System.out.println("second get method for  student whose ID is 1L");
        Student12 student2 = session.get(Student12.class, 1L);

        tx.commit();
        session.close();

        Session session2 = sf.openSession();
        Transaction tx2= session2.beginTransaction();

        System.out.println("third get method for  student whose ID is 1L");
        Student12 student3 = session2.get(Student12.class, 1L); //second level cache is working

        tx2.commit();
        session2.close();
        sf.close();
    }
}
