package orm.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import orm.config.HibernateConfig;
import orm.entity_ex6_7.Jacket;
import orm.entity_ex6_7.Pants;

public class ClothesDaoImpl implements ClothesDao {

    private final SessionFactory sessionFactory;

    public ClothesDaoImpl() {
        this.sessionFactory = HibernateConfig.getSessionFactory();
    }


    @Override
    public void create(Object object) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {

            transaction = session.beginTransaction();
            session.save(object);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if( transaction != null )
                transaction.rollback();
            throw e;
        }

    }

    @Override
    public Jacket readJ(Integer id) {
        Transaction transaction = null;
        Jacket jacket;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            jacket = session.get(Jacket.class, id);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if( transaction != null )
                transaction.rollback();
            throw e;
        }
        return jacket;
    }

    @Override
    public Pants readP(Integer id) {
        Transaction transaction = null;
        Pants pants;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            pants = session.get(Pants.class, id);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if( transaction != null )
                transaction.rollback();
            throw e;
        }
        return pants;
    }



}
