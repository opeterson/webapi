package ca.owenpeterson.web.api.dao;

import ca.owenpeterson.web.api.domain.ServerStatus;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Component;

@Component
public class ServerStatusDao extends HibernateDao {

    public void saveServerStatus(ServerStatus serverStatus)
    {
        save(serverStatus);
    }

    public ServerStatus getServerStatusById(int id)
    {
        Session session = getSession();
        Transaction transaction = session.beginTransaction();
        ServerStatus serverStatus = session.get(ServerStatus.class, id);
        transaction.commit();
        return serverStatus;
    }
}
