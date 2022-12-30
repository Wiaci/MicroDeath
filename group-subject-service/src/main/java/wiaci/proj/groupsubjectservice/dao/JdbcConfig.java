package wiaci.proj.groupsubjectservice.dao;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

@Component
@ConfigurationProperties(prefix = "spring.database")
public class JdbcConfig {

    private String url;
    private String username;
    private String password;

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url,
                username, password);
    }
}
