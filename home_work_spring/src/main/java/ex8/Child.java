package ex8;


import lombok.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Child {

    @Value("Arthur")
    private String nameChild;
    @Value("9")
    private Integer age;
}
