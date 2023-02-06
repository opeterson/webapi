package ca.owenpeterson.web.api.config.spring;

import ca.owenpeterson.web.api.domain.ServerStatus;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class HibernateSessionConfig {

    private static final Logger LOGGER = LogManager.getLogger(HibernateSessionConfig.class);

    private static final String CONNECTION_DRIVER_CLASS = "com.mysql.cj.jdbc.Driver";
    private static final String DIALECT = "org.hibernate.dialect.MySQL8Dialect";
    private static final String CONNECTION_URL = "jdbc:mysql://host.docker.internal:3306/web-api-database";
    private static final String CONNECTION_USERNAME = "user";
    private static final String CONNECTION_PASSWORD = "password";
    private static final String SESSION_CONTEXT_CLASS = "thread";
    private static final String SHOW_SQL = "true";
    private static final String FORMAT_SQL = "true";
    private static final String C3P0_MIN_SIZE = "5";
    private static final String C3P0_MAX_SIZE = "20";
    private static final String C3P0_ACQUIRE_INCREMENT = "5";
    private static final String C3P0_TIMEOUT = "1800";
    private static final String HBM2DDL_AUTO = "create";

    @Bean
    public SessionFactory sessionFactory()
    {
        LOGGER.info("Creating Hibernate SessionFactory bean");
        Map<String, Object> settings = new HashMap<>();
        settings.put("hibernate.connection.driver_class", CONNECTION_DRIVER_CLASS);
        settings.put("hibernate.dialect", DIALECT);
        settings.put("hibernate.connection.url", CONNECTION_URL);
        settings.put("hibernate.connection.username", CONNECTION_USERNAME);
        settings.put("hibernate.connection.password", CONNECTION_PASSWORD);
        settings.put("hibernate.current_session_context_class", SESSION_CONTEXT_CLASS);
        settings.put("hibernate.show_sql", SHOW_SQL);
        settings.put("hibernate.format_sql", FORMAT_SQL);
        settings.put("hibernate.c3p0.min_size", C3P0_MIN_SIZE);
        settings.put("hibernate.c3p0.max_size", C3P0_MAX_SIZE);
        settings.put("hibernate.c3p0.acquire_increment", C3P0_ACQUIRE_INCREMENT);
        settings.put("hibernate.c3p0.timeout", C3P0_TIMEOUT);
        settings.put("hibernate.hbm2ddl.auto", HBM2DDL_AUTO);

        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                .applySettings(settings).build();

        MetadataSources metadataSources = new MetadataSources(serviceRegistry);
        metadataSources.addAnnotatedClass(ServerStatus.class);
        //TODO: try to get it scanning a whole dao package.
        //metadataSources.addPackage("ca.owenpeterson.web.api.domain.*");
        Metadata metadata = metadataSources.buildMetadata();

        SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build();
        LOGGER.info("Successfully created SessionFactory bean");
        return sessionFactory;
    }
}
