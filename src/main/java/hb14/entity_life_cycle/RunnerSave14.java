package hb14.entity_life_cycle;

import hb13.get_load.Student13;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerSave14 {
    public static void main(String[] args) {

        Student14 student1 = new Student14(); //transient state--> hibernate has no responsibility,
        // hibernate will not track
        student1.setName("AAA");
        student1.setGrade(90);

        Configuration con = new Configuration().
                configure("hibernate.cfg.xml").
                addAnnotatedClass(Student14.class);

        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();

        session.save(student1); //persistent state-->from here onwards, hibernate will track my obj

        student1.setName("BBB"); // name of obj will be BBB, because it is in persistent state, and it is tracked

        session.evict(student1); // persistent obj is taken to detached state... this will not be tracked
        //changes to obj will not be stored to DB. it is like rollback

        student1.setName("CCC");//obj is still in detached state

        session.update(student1); //detached obj will be taken into persistent state
        // session.merge(student1);
        student1.setName("DDD");


        tx.commit();
        session.close();
        sf.close();
    }
}
