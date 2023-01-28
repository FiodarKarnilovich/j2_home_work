package orm.ex8.table_per_class;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "employee3")
@Getter
@Setter
@NoArgsConstructor
public class Employee3 extends Person3 {

    @Column
    private String company;

    @Column
    private String position;

    public Employee3(int id, String firstName, String lastName, String company, String position) {
        super(id, firstName, lastName);
        this.company = company;
        this.position = position;
    }

    @Override
    public String toString() {
        return "Employee3{" +
                "id=" + super.getId() +
                ", firstName='" + super.getFirstName() + '\'' +
                ", lastName='" + super.getLastName() + '\'' +
                "company='" + company + '\'' +
                ", position='" + position + '\'' +
                '}';
    }
}
