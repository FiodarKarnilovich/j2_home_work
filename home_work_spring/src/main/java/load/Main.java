package load;


import ex2.Person;
import ex8.Child;
import ex8.Parent;
import ex9.Animal;
import ex9.Lion;
import ex9.Tiger;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Person.class, Parent.class, Child.class,
                Animal.class, Lion.class, Tiger.class);
        Person person = context.getBean("person", Person.class);
        System.out.println(person);

        Parent parent = context.getBean("parent", Parent.class);

        System.out.println(parent);

        Animal animal = context.getBean("animal", Animal.class);

        System.out.println(animal);
    }
}
