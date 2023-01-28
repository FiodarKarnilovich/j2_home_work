package orm.ex8.single_table.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import orm.config.HibernateConfig;
import orm.ex8.single_table.Person1;

import java.util.List;

public class SingleTableDaoImpl implements SingleTableDao {

    private final SessionFactory sessionFactory;

    public SingleTableDaoImpl() {
        this.sessionFactory = HibernateConfig.getSessionFactory();
    }

    @Override
    public void create(Person1 person1) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {

            transaction = session.beginTransaction();
            session.save(person1);
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
        List persons = session.createQuery("from Person1", Person1.class).list();
        session.close();
        return persons;
    }
}
