package ca.owenpeterson.web.api.config.spring;

import ca.owenpeterson.web.api.dao.ServerStatusDao;
import ca.owenpeterson.web.api.domain.ServerStatus;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class ApplicationStartup implements ApplicationListener<ContextRefreshedEvent> {

    private static final Logger LOGGER = LogManager.getLogger(ApplicationStartup.class);

    @Autowired
    private ServerStatusDao serverStatusDao;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
    LOGGER.info("Running post server startup initialization.");
    LocalDateTime currentDateTime = LocalDateTime.now();
    ServerStatus serverStatus = serverStatusDao.getServerStatusById(1);

        if (null == serverStatus)
        {
            ServerStatus newRow = new ServerStatus();
            newRow.setStatus("ONLINE");
            newRow.setStartUpTime(currentDateTime);
            serverStatusDao.saveServerStatus(newRow);
        }
        else
        {
            serverStatus.setStartUpTime(currentDateTime);
            serverStatusDao.updateServerStatus(serverStatus);
        }

        LOGGER.info("Server status updated to current date time: " + currentDateTime);
    }
}