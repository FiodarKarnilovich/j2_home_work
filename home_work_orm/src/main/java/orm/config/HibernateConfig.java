package orm.config;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import orm.entity_ex6_7.Jacket;
import orm.entity_ex6_7.Pants;
import orm.ex8.joined.Employee2;
import orm.ex8.joined.Person2;
import orm.ex8.joined.Student2;
import orm.ex8.single_table.Employee1;
import orm.ex8.single_table.Person1;
import orm.ex8.single_table.Student1;
import orm.ex8.table_per_class.Employee3;
import orm.ex8.table_per_class.Person3;
import orm.ex8.table_per_class.Student3;

public class HibernateConfig {
    private static HibernateConfig INSTANCE;
    private static SessionFactory sessionFactory;

    private HibernateConfig() {
        try {
            Configuration configuration = new Configuration()
                    .addAnnotatedClass(Jacket.class)
                    .addAnnotatedClass(Pants.class)
                    .addAnnotatedClass(Person1.class)
                    .addAnnotatedClass(Student1.class)
                    .addAnnotatedClass(Employee1.class)
                    .addAnnotatedClass(Person2.class)
                    .addAnnotatedClass(Student2.class)
                    .addAnnotatedClass(Employee2.class)
                    .addAnnotatedClass(Person3.class)
                    .addAnnotatedClass(Student3.class)
                    .addAnnotatedClass(Employee3.class)

                    .configure();
            StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
                    .applySettings(configuration.getProperties());
            sessionFactory = configuration.buildSessionFactory(builder.build());
        } catch (Throwable e) {
            System.err.println("Initial SessionFactory creation failed." + e);
            throw new ExceptionInInitializerError(e);
        }
    }


    public static SessionFactory getSessionFactory() {
        if (INSTANCE == null) {
            INSTANCE = new HibernateConfig();
        }
        return sessionFactory;
    }
}
