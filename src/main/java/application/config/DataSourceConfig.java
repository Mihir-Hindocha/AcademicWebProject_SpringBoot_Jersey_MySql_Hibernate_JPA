package application.config;

import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

import javax.sql.DataSource;
import java.util.Properties;


@Configuration
public class DataSourceConfig {

    private static final String PROPERTY_NAME_HIBERNATE_DIALECT = "hibernate.dialect";
    private static final String PROPERTY_NAME_HIBERNATE_SHOW_SQL = "hibernate.show_sql";
    private static final String PROPERTY_NAME_HIBERNATE_BATCH_SIZE = "hibernate.jdbc.batch_size";
    public static final String BASE_PACKAGE = "application.model";

    public DriverManagerDataSource createDataSourceNonPooled() {
        DriverManagerDataSource mySqlDataSource = new DriverManagerDataSource();
        mySqlDataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        mySqlDataSource
                .setUrl("jdbc:mysql://localhost:3306/shubhmangalgreens");
        mySqlDataSource.setUsername("root");
        mySqlDataSource.setPassword("");

        return mySqlDataSource;
    }

    @Bean
    public DataSource createDataSource() {
        return createDataSourceNonPooled();
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
        entityManagerFactoryBean.setDataSource(createDataSource());
        entityManagerFactoryBean.setPersistenceProviderClass(HibernatePersistenceProvider.class);
        entityManagerFactoryBean.setPackagesToScan(BASE_PACKAGE);
        entityManagerFactoryBean.setPersistenceUnitName("testJPA");
        entityManagerFactoryBean.setJpaProperties(jpaProperties());

        return entityManagerFactoryBean;
    }

    private Properties jpaProperties() {
        Properties jpaProperties = new Properties();
        jpaProperties.put(PROPERTY_NAME_HIBERNATE_DIALECT,
                "org.hibernate.dialect.MySQL5InnoDBDialect");
        jpaProperties.put(PROPERTY_NAME_HIBERNATE_SHOW_SQL, "true");
        jpaProperties.put("hibernate.ddl-auto", "update");
        jpaProperties.put(PROPERTY_NAME_HIBERNATE_BATCH_SIZE, 80);
        jpaProperties.put("hibernate.order_inserts", "true");
        jpaProperties.put("hibernate.order_updates", "true");
        return jpaProperties;
    }

    @Bean
    public JpaTransactionManager transactionManager() {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactory()
                .getObject());
        return transactionManager;
    }

    @Bean
    public JdbcTemplate mysqlJdbcTemplate() {
        return new JdbcTemplate(createDataSource());
    }

    @Bean
    public NamedParameterJdbcTemplate mysqlNamedParameterJdbcTemplate() {
        return new NamedParameterJdbcTemplate(createDataSource());
    }
}
