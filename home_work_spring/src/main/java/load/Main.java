package load;


import ex2.Person;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Person.class);
        Person person = context.getBean("person", Person.class);
        System.out.println(person);
    }
}
