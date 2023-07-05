package hb06.uni_onetomany;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="t_book06")
public class Book06 {

    @Id
    private int id;

    @Column(name="book_name", nullable = false, length = 100)
    private String name;



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

    //toString

    @Override
    public String toString() {
        return "Book06{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
