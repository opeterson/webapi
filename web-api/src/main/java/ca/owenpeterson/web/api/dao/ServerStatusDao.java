package ca.owenpeterson.web.api.dao;

import ca.owenpeterson.web.api.domain.ServerStatus;
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
        ServerStatus serverStatus = getById(ServerStatus.class, id);
        return serverStatus;
    }
}
