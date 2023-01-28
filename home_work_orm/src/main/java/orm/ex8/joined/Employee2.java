package orm.ex8.joined;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "employee2")
@PrimaryKeyJoinColumn(name = "employee2_id")
public class Employee2 extends Person2{

    private String company;

    private String position;

    public Employee2(int id, String firstName, String lastName, String company, String position) {
        super(id, firstName, lastName);
        this.company = company;
        this.position = position;
    }

    @Override
    public String toString() {
        return "Employee2{" +
                "id=" + super.getId() +
                ", firstName='" + super.getFirstName() + '\'' +
                ", lastName='" + super.getLastName() + '\'' +
                "company='" + company + '\'' +
                ", position='" + position + '\'' +
                '}';
    }
}
