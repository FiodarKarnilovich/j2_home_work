package orm.ex8.single_table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "employee1")
@DiscriminatorValue("E")
@Getter
@Setter
@NoArgsConstructor
public class Employee1 extends Person1{

    @Column
    private String company;

    @Column
    private String position;

    public Employee1(int id, String firstName, String lastName, String company, String position) {
        super(id, firstName, lastName);
        this.company = company;
        this.position = position;
    }

    @Override
    public String toString() {
        return "Employee1{" +
                "id=" + super.getId() +
                ", firstName='" + super.getFirstName() + '\'' +
                ", lastName='" + super.getLastName() + '\'' +
                "company='" + company + '\'' +
                ", position='" + position + '\'' +
                '}';
    }
}
