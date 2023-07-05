package hb12.caching;

import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import org.hibernate.annotations.Cache;

@Entity
@Table(name="t_student12")

@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE, region = "Student12")
public class Student12 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "std_name", nullable = false)
    private String name;
    private int grade;

    //getter-setter


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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
        return "Student12{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", grade=" + grade +
                '}';
    }
}
