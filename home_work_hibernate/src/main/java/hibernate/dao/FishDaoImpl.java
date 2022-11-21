package hibernate.dao;

import hibernate.model.Fish;
import hibernate.util.MysqlSessionFactory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class FishDaoImpl implements FishDao{

    private final SessionFactory sessionFactory;

    public FishDaoImpl() {
        this.sessionFactory = MysqlSessionFactory.getInstance();
    }

    public FishDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void create(Fish fish) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {

            transaction = session.beginTransaction();
            session.save(fish);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if( transaction != null )
                transaction.rollback();
            throw e;
        }
    }

    @Override
    public void delete(Fish fish) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {

            transaction = session.beginTransaction();
            session.delete(fish);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if( transaction != null )
                transaction.rollback();
            throw e;
        }

    }

    @Override
    public Fish search(int id) {

        Transaction transaction = null;
        Fish fish = new Fish();
        try (Session session = sessionFactory.openSession()) {

            transaction = session.beginTransaction();
            fish = session.get(Fish.class, id);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if( transaction != null )
                transaction.rollback();
            throw e;
        }
        return fish;
    }
}
