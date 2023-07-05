package hb14.entity_life_cycle.some_methods;

import javax.persistence.*;

@Entity
@Table(name="t_employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="employee_id")
    private Long id;
    @Column(name="empl_name")
    private String name;
    @Column(name="empl_salary")
    private Double salary;

    //methods
    @PrePersist
    public void onPrepersist(){
        System.out.println("********* Before data being persist ******");
    }


    @PostPersist
    public void onPostPersist(){
        System.out.println("********* After data being persist ******");
    }


    @PostLoad
    public void onPostLoad(){
        System.out.println("********* After loading data ******");
    }

    @PreRemove
    public void onPreRemove(){
        System.out.println("********* Before data being removed ******");
    }

    @PostRemove
    public void onPostRemove(){
        System.out.println("********* After data is being removed ******");
    }



    //setter and getter


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

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    //toString

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }
}
