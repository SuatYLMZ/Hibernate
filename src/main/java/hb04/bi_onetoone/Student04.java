package hb04.bi_onetoone;

import javax.persistence.*;

@Entity
@Table(name = "t_student04")
public class Student04 {

    @Id
    private int id;

    @Column(name = "std_name",length = 100,nullable = false)
    private String name;
    private int grade;

    @OneToOne(mappedBy = "student")// mappedBy attributes will not create any column in dairy class
    // instead it will use the column from dairy class which named as "student"
    private Dairy04 dairy;

    // getter and setter


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

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public Dairy04 getDairy() {
        return dairy;
    }

    public void setDairy(Dairy04 dairy) {
        this.dairy = dairy;
    }

    // to String method


    @Override
    public String toString() {
        return "Student04{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", grade=" + grade +
//sin               ", dairy=" + dairy + // delete comment this to avoid stack overflow
                '}';
    }
}
