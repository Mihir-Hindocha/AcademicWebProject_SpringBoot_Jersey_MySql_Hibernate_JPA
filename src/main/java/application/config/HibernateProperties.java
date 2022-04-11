package application.config;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HibernateProperties {
    private String dialect;
    private Boolean showSql;
    private String persistenceUnitName;
}
