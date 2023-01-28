package entity;


import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "jacket")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Jacket {

    @Id
    @Column(name = "jacket_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String model;

    private Double price;

    @Override
    public String toString() {
        return "Jacket{" +
                "id=" + id +
                ", model='" + model + '\'' +
                ", price=" + price +
                '}';
    }
}
