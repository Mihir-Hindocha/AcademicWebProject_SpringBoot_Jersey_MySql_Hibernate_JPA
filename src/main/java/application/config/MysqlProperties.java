package application.config;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MysqlProperties {
    private String driverClassName;
    private String url;
    private String username;
    private String password;
    private Integer maxPoolSize;
}
