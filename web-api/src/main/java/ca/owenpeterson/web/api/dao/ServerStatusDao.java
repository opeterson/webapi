package ca.owenpeterson.web.api.dao;

import ca.owenpeterson.web.api.domain.ServerStatus;
import org.apache.logging.log4j.core.jmx.Server;
import org.hibernate.Session;
import org.springframework.stereotype.Component;

@Component
public class ServerStatusDao extends HibernateDao {

    public void saveServerStatus(ServerStatus serverStatus)
    {
        Session session = getSession();
        save(serverStatus);
    }

    public ServerStatus getServerStatusById(int id)
    {
        Session session = getSession();
        ServerStatus serverStatus = (ServerStatus) session.get("server_status", id);
        return serverStatus;
    }
}
