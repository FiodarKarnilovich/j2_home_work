package dao;


import entity.Jacket;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class JacketDaoImpl implements JacketDao{

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void addJacket(Jacket jacket) {
        sessionFactory.getCurrentSession().saveOrUpdate(jacket);

    }

    @Override
    public Jacket getJacket(Integer id) {
        return sessionFactory.getCurrentSession().get(Jacket.class, id);
    }

    @Override
    public void deleteJacket(Integer id) {
        sessionFactory.getCurrentSession().delete(getJacket(id));

    }
}
