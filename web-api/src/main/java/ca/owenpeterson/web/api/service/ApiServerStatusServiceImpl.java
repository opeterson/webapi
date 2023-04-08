package ca.owenpeterson.web.api.service;

import ca.owenpeterson.web.api.client.model.ApiServerStatus;
import ca.owenpeterson.web.api.dao.ServerStatusDao;
import ca.owenpeterson.web.api.domain.ServerStatus;
import ca.owenpeterson.web.api.transformer.api.ApiServerStatusToServerStatusTransformer;
import ca.owenpeterson.web.api.transformer.domain.ServerStatusToApiServerStatusTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ApiServerStatusServiceImpl {

    @Autowired
    private ServerStatusDao serverStatusDao;

    @Autowired
    private ApiServerStatusToServerStatusTransformer serverStatusApiToDomainTransformer;

    @Autowired
    private ServerStatusToApiServerStatusTransformer serverStatusDomainToApiTransformer;

    public void saveServerStatus(ApiServerStatus apiServerStatus)
    {
        if (null != apiServerStatus)
        {
            ServerStatus serverStatus = serverStatusApiToDomainTransformer.transform(apiServerStatus);

            if (null != serverStatus) {
                serverStatusDao.saveServerStatus(serverStatus);
            }
        }
    }

    public ApiServerStatus getServerStatusById(int id)
    {
        ServerStatus serverStatus = serverStatusDao.getServerStatusById(id);
        return serverStatusDomainToApiTransformer.transform(serverStatus);
    }
}
