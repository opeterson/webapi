package ca.owenpeterson.web.api.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class HibernateDao {

    @Autowired
    private SessionFactory sessionFactory;

    public Session getSession()
    {
        return sessionFactory.getCurrentSession();
    }

    public void save(Object object)
    {
        Session session = getSession();
        Transaction transaction = session.beginTransaction();
        session.persist(object);
        transaction.commit();
    }

    public void update(Object object)
    {
        Session session = getSession();
        Transaction transaction = session.beginTransaction();
        session.merge(object);
        transaction.commit();
    }

    public <T> T getById(Class<T> entityClass, int id)
    {
        Session session = getSession();
        Transaction transaction = session.beginTransaction();
        T result = (T) session.get(entityClass, id);
        transaction.commit();
        return result;
    }
}
