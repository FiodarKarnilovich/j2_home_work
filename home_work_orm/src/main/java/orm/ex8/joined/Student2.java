package orm.ex8.joined;


import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "student2")
@PrimaryKeyJoinColumn(name = "person2_id")
@AllArgsConstructor
@NoArgsConstructor
public class Student2 extends Person2{

    private String faculty;

    private String university;

    public Student2(int id, String firstName, String lastName, String university, String faculty) {
        super(id, firstName, lastName);
        this.university = university;
        this.faculty = faculty;
    }

    @Override
    public String toString() {
        return "Student2{" +
                "id=" + super.getId() +
                ", firstName='" + super.getFirstName() + '\'' +
                ", lastName='" + super.getLastName() + '\'' +
                "university='" + university + '\'' +
                ", faculty='" + faculty + '\'' +
                '}';
    }
}
