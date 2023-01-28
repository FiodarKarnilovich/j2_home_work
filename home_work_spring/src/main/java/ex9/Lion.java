package ex9;

import lombok.ToString;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@ToString
public class Lion implements ICats{

    @Value("Egypt")
    private String country;
}
