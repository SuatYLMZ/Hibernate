package hb01.annotation;

import javax.persistence.*;

    @Entity  //this class will be mapped to table
    @Table(name="t_student01") //to customize table name
    public class Student01 { //default name of the table will be "student01"

    @Id //the field under @Id will be a Primary Key
    private int id;
    @Column(name="std_name", length = 100, nullable = false, unique = false)
    private String name; //by default variable name will be the column name
    //@Transient //this field will not be added to the table
    private int grade;

//    @Lob //large object
//    private byte[] image;


    //getter--setter


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

    //toString

    @Override
    public String toString() {
        return "Student01{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", grade=" + grade +
                '}';
    }
}