package application.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.ejb.HibernatePersistence;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

import com.mchange.v2.c3p0.ComboPooledDataSource;


@Configuration
public class DataSourceConfig {

	private static final String PROPERTY_NAME_HIBERNATE_DIALECT = "hibernate.dialect";
	private static final String PROPERTY_NAME_HIBERNATE_SHOW_SQL = "hibernate.show_sql";
	private static final String PROPERTY_NAME_HIBERNATE_BATCH_SIZE = "hibernate.jdbc.batch_size";
	public static final String BASE_PACKAGE = "application.model";

	// private @Autowired MysqlProperties mysqlProperties;
	// private @Autowired HibernateProperties hibernateProperties;

	public DataSource createDataSourcePooled() throws Exception {
		ComboPooledDataSource ds = new ComboPooledDataSource();
		ds.setJdbcUrl("jdbc:mysql://localhost:3306/shubhmangalgreens");
		ds.setDriverClass("com.mysql.jdbc.Driver");
		ds.setUser("root");
		ds.setPassword("");
		ds.setMaxPoolSize(10);
		ds.setInitialPoolSize(2);
		ds.setAcquireIncrement(2);

		return ds;
	}

	public DriverManagerDataSource createDataSourceNonPooles() {
		DriverManagerDataSource mySqlDataSource = new DriverManagerDataSource();
		mySqlDataSource.setDriverClassName("com.mysql.jdbc.Driver");
		mySqlDataSource
				.setUrl("jdbc:mysql://localhost:3306/shubhmangalgreens");
		mySqlDataSource.setUsername("root");
		mySqlDataSource.setPassword("");

		return mySqlDataSource;
	}

	@Bean
	public DataSource createDataSource() {
		return createDataSourceNonPooles();
	}

	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
		entityManagerFactoryBean.setDataSource(createDataSource());
		entityManagerFactoryBean.setPersistenceProviderClass(HibernatePersistence.class);
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
