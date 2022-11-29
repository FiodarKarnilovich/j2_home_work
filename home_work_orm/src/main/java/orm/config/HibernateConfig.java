package orm.config;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import orm.entity.Jacket;
import orm.entity.Pants;

public class HibernateConfig {
    private static HibernateConfig INSTANCE;
    private static SessionFactory sessionFactory;

    private HibernateConfig() {
        try {
            Configuration configuration = new Configuration()
                    .addAnnotatedClass(Jacket.class)
                    .addAnnotatedClass(Pants.class)
//                    .addAnnotatedClass(Person.class)
//                    .addAnnotatedClass(Student.class)
//                    .addAnnotatedClass(Teacher.class)
//                    .addAnnotatedClass(Person2.class)
//                    .addAnnotatedClass(Student2.class)
//                    .addAnnotatedClass(Teacher2.class)
//                    .addAnnotatedClass(Person3.class)
//                    .addAnnotatedClass(Student3.class)
//                    .addAnnotatedClass(Teacher3.class)
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
