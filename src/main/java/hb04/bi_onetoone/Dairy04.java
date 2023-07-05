package hb04.bi_onetoone;

import javax.persistence.*;

@Entity
@Table(name = "t_dairy04")
public class Dairy04 {

    @Id
    private int id;

    private String name;

    @OneToOne//student_id
    @JoinColumn(name="std_id", unique = true) //to avoid duplication
    private Student04 student;

    //getter and setter


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Student04 getStudent() {
        return student;
    }

    public void setStudent(Student04 student) {
        this.student = student;
    }


    // to string method
    @Override
    public String toString() {
        return "Dairy04{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", student=" + student +
                '}';
    }



}
