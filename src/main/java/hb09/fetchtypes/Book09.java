package hb09.fetchtypes;

import hb07.bi_onetomany.Student07;

import javax.persistence.*;

@Entity
@Table (name = "t_book09")
public class Book09 {
    @Id
    private int id;
    private String name;

    @ManyToOne()
    @JoinColumn(name="std_id")
    private Student09 student; //student_id

    //getter-setter

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

    public Student09 getStudent() {
        return student;
    }

    public void setStudent(Student09 student) {
        this.student = student;
    }
    //toString

    @Override
    public String toString() {
        return "Book09{" +
                "id=" + id +
                ", name='" + name + '\'' +
                // ", student=" + student +
                '}';
    }
}
