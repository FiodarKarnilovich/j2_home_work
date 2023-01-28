package orm.ex8.table_per_class;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "student3")
@Getter
@Setter
@NoArgsConstructor
public class Student3 extends Person3 {

    @Column
    private String university;

    @Column
    private String faculty;

    public Student3(int id, String firstName, String lastName, String university, String faculty) {
        super(id, firstName, lastName);
        this.university = university;
        this.faculty = faculty;
    }

    @Override
    public String toString() {
        return "Student3{" +
                "id=" + super.getId() +
                ", firstName='" + super.getFirstName() + '\'' +
                ", lastName='" + super.getLastName() + '\'' +
                "university='" + university + '\'' +
                ", faculty='" + faculty + '\'' +
                '}';
    }
}
