package orm.ex8.table_per_class.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import orm.config.HibernateConfig;
import orm.ex8.table_per_class.Person3;

import java.util.List;

public class PerTableDaoImpl implements PerTableDao {

    private final SessionFactory sessionFactory;

    public PerTableDaoImpl() {
        this.sessionFactory = HibernateConfig.getSessionFactory();
    }

    @Override
    public void create(Person3 person3) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {

            transaction = session.beginTransaction();
            session.save(person3);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if( transaction != null )
                transaction.rollback();
            throw e;
        }
    }

    @Override
    public List readAll() {
        Session session = sessionFactory.openSession();
        List persons = session.createQuery("from Person3", Person3.class).list();
        session.close();
        return persons;
    }
}
