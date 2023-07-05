package hb14.entity_life_cycle.some_methods;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerSaveEmpl {
    public static void main(String[] args) {

        Employee employee = new Employee();
        employee.setName("Aaaa");
        employee.setSalary(9089.9);

        Configuration con = new Configuration().
                configure("hibernate.cfg.xml").
                addAnnotatedClass(Employee.class);

        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();

        //session.save(employee);
        Employee employee1 = session.get(Employee.class, 1L);

        session.delete(employee1);





        tx.commit();
        session.close();
        sf.close();
    }
}
