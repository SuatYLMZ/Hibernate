package hb11.criteriaapi;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.Random;

public class  RunnerFetch11 {
    public static void main(String[] args) {

        Configuration con = new Configuration().
                configure("hibernate.cfg.xml").
                addAnnotatedClass(Student11.class);
        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();


        /*

            CRUD (Create, Read, Update, Delete)

                C --> session.save(), session.persist()
                R --> session.get(), HQL, SQL
                U --> session.update(), updateQuery
                D --> session.delete(), HQL, SQL
         */

        //1. update existing data

//        Student11 student = session.get(Student11.class, 1L);
//        student.setName("Updated "+ student.getName());
//        session.update(student);

        //2. update student using query
        //update grades that are less than 50 to 70

//        int sGrade = 70;
//        int lGrade = 50;
////
//        String hqlQuery = "UPDATE Student11 s SET s.grade =:sMath WHERE s.grade<:lMath";
//        Query query = session.createQuery(hqlQuery);
//        query.setParameter("sMath", sGrade);
//        query.setParameter("lMath", lGrade);

//        int numOfUpdatedRecords =  query.executeUpdate();
//        System.out.println("Number of updated records: "+numOfUpdatedRecords);

        CriteriaBuilder cb =  session.getCriteriaBuilder();
        CriteriaQuery<Student11> criteriaQuery =  cb.createQuery(Student11.class);
        Root<Student11> root =  criteriaQuery.from(Student11.class);

        //example 1: select all students
//        criteriaQuery.select(root); // SELECT * FROM t_student11
//        String query = "SELECT * FROM t_student11";
//
//        Query<Student11> query1 =  session.createQuery(criteriaQuery);
//        List<Student11> resultList1 =  query1.getResultList();
//        resultList1.forEach(s-> System.out.println(s));


        //example 2 : get student whose name is: "Student Name 6"
//        criteriaQuery.select(root). // SELECT * FROM t_student11
//                where(cb.equal(root.get("name"), "Student Name 6")); //WHERE condition
//
//        Query<Student11> query2 =  session.createQuery(criteriaQuery);
//        List<Student11> resultList2 =  query2.getResultList();
//        resultList2.forEach(s-> System.out.println(s));

        //example 3
        //fetch students whose grade is > 80
//        criteriaQuery.select(root).
//                where(cb.greaterThan(root.get("grade"), 80));
//
//        Query<Student11> query3 =  session.createQuery(criteriaQuery);
//        List<Student11> resultList3 =  query3.getResultList();
//        resultList3.forEach(s-> System.out.println(s));

        //example 4

        //task: fetch students whose grade is less than 90
//        criteriaQuery.select(root).
//                where(cb.lessThan(root.get("grade"), 90));
//
//        Query<Student11> query4 =  session.createQuery(criteriaQuery);
//        List<Student11> resultList4 =  query4.getResultList();
//        resultList4.forEach(s-> System.out.println(s));


        //Example 5--> find records whose id =1, or grade is greater than 75

        Predicate predicateForId = cb.equal(root.get("id"), 1L);
        Predicate predicateForGrade=  cb.greaterThan(root.get("grade"), 75);
        Predicate predicateForOr =  cb.or(predicateForGrade, predicateForId);

        criteriaQuery.where(predicateForOr);

        Query<Student11> query5 =  session.createQuery(criteriaQuery);
        List<Student11> resultList5 =  query5.getResultList();
        resultList5.forEach(s-> System.out.println(s));


        tx.commit();
        session.close();
        sf.close();

    }
}
