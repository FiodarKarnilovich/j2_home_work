package ex2;

import lombok.*;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
//@Component
public class Person implements InitializingBean, DisposableBean {

    private String firstName;
    private String lastName;

    @Override
    public void destroy() throws Exception {
        System.out.println("Destroying");
    }

    @Override
    public void afterPropertiesSet() throws Exception {

    }

    public void init() throws Exception {
        System.out.println("Call init");
    }

    @Bean
    public Person getPerson() {
        return new Person(firstName, lastName);
    }
}
