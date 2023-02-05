package ca.owenpeterson.web.api.service;

import ca.owenpeterson.web.api.dao.ServerStatusDao;
import ca.owenpeterson.web.api.domain.ServerStatus;
import org.apache.logging.log4j.core.jmx.Server;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ServerStatusServiceImpl {

    @Autowired
    private ServerStatusDao serverStatusDao;

    public void saveServerStatus(ServerStatus serverStatus)
    {
        serverStatusDao.saveServerStatus(serverStatus);
    }

    public ServerStatus getServerStatusById(int id)
    {
        return serverStatusDao.getServerStatusById(id);
    }
}
