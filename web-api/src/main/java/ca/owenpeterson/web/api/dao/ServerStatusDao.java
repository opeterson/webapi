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

    public void updateServerStatus(ServerStatus serverStatus)
    {
        update(serverStatus);
    }

    public ServerStatus getServerStatusById(int id)
    {
        //TODO: add getById to hibernateDao and update this code to pass relevant data to it.
        Session session = getSession();
        Transaction transaction = session.beginTransaction();
        ServerStatus serverStatus = session.get(ServerStatus.class, id);
        transaction.commit();
        return serverStatus;
    }
}
