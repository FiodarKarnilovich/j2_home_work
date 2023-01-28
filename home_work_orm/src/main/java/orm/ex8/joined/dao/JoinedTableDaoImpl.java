package orm.ex8.joined.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import orm.config.HibernateConfig;
import orm.ex8.joined.Person2;
import orm.ex8.single_table.Person1;
import orm.ex8.single_table.dao.SingleTableDao;

import java.util.List;

public class JoinedTableDaoImpl implements JoinedTableDao {

    private final SessionFactory sessionFactory;

    public JoinedTableDaoImpl() {
        this.sessionFactory = HibernateConfig.getSessionFactory();
    }

    @Override
    public void create(Person2 person2) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {

            transaction = session.beginTransaction();
            session.save(person2);
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
        List persons = session.createQuery("from Person2", Person2.class).list();
        session.close();
        return persons;
    }
}
