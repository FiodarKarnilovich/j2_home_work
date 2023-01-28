package orm.entity_ex6_7;

import lombok.*;


import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Pants implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pants_seq")
    @SequenceGenerator(name = "pants_seq", sequenceName = "pants_seq")
    private Integer id;

    private String name;

    private Double price;
    private PantsDescription pantsDescription;

    @Override
    public String toString() {
        return "Pants{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", color=" + pantsDescription.getColor() +
                ", size=" + pantsDescription.getSize() +
                '}';
    }
}
