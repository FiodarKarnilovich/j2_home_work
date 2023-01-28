package orm.ex8.single_table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "student1")
@DiscriminatorValue("S")
@Getter
@Setter
@NoArgsConstructor
public class Student1 extends Person1{

    @Column
    private String university;

    @Column
    private String faculty;

    public Student1(int id, String firstName, String lastName, String university, String faculty) {
        super(id, firstName, lastName);
        this.university = university;
        this.faculty = faculty;
    }

    @Override
    public String toString() {
        return "Student1{" +
                "id=" + super.getId() +
                ", firstName='" + super.getFirstName() + '\'' +
                ", lastName='" + super.getLastName() + '\'' +
                "university='" + university + '\'' +
                ", faculty='" + faculty + '\'' +
                '}';
    }
}
