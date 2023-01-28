package load;


import ex2.Person;
import ex8.Child;
import ex8.Parent;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Person.class, Parent.class, Child.class);
        Person person = context.getBean("person", Person.class);
        System.out.println(person);

        Parent parent = context.getBean("parent", Parent.class);

        System.out.println(parent);
    }
}
