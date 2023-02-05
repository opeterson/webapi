package ca.owenpeterson.web.api.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
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
        session.persist(object);
    }
}
