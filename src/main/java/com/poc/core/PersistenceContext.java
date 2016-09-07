package com.poc.core;

import java.util.Properties;

import javax.sql.DataSource;

import org.jooq.SQLDialect;
import org.jooq.TransactionProvider;
import org.jooq.conf.Settings;
import org.jooq.impl.DataSourceConnectionProvider;
import org.jooq.impl.DefaultConfiguration;
import org.jooq.impl.DefaultDSLContext;
import org.jooq.impl.DefaultExecuteListenerProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.LazyConnectionDataSourceProxy;
import org.springframework.jdbc.datasource.TransactionAwareDataSourceProxy;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

/**
 * 
 * @author joliveros
 * based on
 * @see https://www.petrikainulainen.net/programming/jooq/using-jooq-with-spring-configuration/
 */
@Configuration
@EnableTransactionManagement
@PropertySource("classpath:project.properties")
public class PersistenceContext {
    private static final String PROPERTY_NAME_DB_PASSWORD = "db.password";
    private static final String PROPERTY_NAME_DB_USERNAME = "db.username";
    private static final String PROPERTY_NAME_DB_URL = "db.url";
    
    private static final String PROPERTY_NAME_DB_DATASOURCECLASSNAME = "db.dataSourceClassName";
    private static final String PROPERTY_NAME_JOOQ_SQL_DIALECT = "jooq.sql.dialect";
    
    private static final String PROPERTY_NAME_MAXPOOL = "db.maximumPoolSize";
    private static final String PROPERTY_NAME_MIN_IDLE = "db.minimumIdle";
    private static final String PROPERTY_NAME_CONNECTIONTIMEOUT = "db.connectionTimeout";
    private static final String PROPERTY_NAME_IDLETIMEOUT = "db.idleTimeout";
    
    @Autowired
    private Environment env;
    
    @Bean(destroyMethod = "close")
    public DataSource dataSource() {

		Properties dsProps = new Properties();
		dsProps.put("url", env.getRequiredProperty(PROPERTY_NAME_DB_URL));
		dsProps.put("user", env.getRequiredProperty(PROPERTY_NAME_DB_USERNAME));
		dsProps.put("password", env.getRequiredProperty(PROPERTY_NAME_DB_PASSWORD));
		
		Properties configProps = new Properties();
		configProps.put("dataSourceClassName",env.getRequiredProperty(PROPERTY_NAME_DB_DATASOURCECLASSNAME));
		configProps.put("poolName","SpringBootHikariCP");
		configProps.put("maximumPoolSize",env.getRequiredProperty(PROPERTY_NAME_MAXPOOL));
		configProps.put("minimumIdle",env.getRequiredProperty(PROPERTY_NAME_MIN_IDLE));
		configProps.put("connectionTimeout", env.getRequiredProperty(PROPERTY_NAME_CONNECTIONTIMEOUT));
		configProps.put("idleTimeout", env.getRequiredProperty(PROPERTY_NAME_IDLETIMEOUT));
		configProps.put("dataSourceProperties", dsProps);
		   
		HikariConfig hc = new HikariConfig(configProps);
		HikariDataSource ds = new HikariDataSource(hc);
		    
		ds.addDataSourceProperty("cachePrepStmts", true);
		ds.addDataSourceProperty("prepStmtCacheSize", 250);
		ds.addDataSourceProperty("prepStmtCacheSqlLimit", 2048);
		ds.addDataSourceProperty("useServerPrepStmts", true);
       
        return ds;
    }
    
    @Bean
    public LazyConnectionDataSourceProxy lazyConnectionDataSource() {
        return new LazyConnectionDataSourceProxy(dataSource());
    }

    @Bean
    public TransactionAwareDataSourceProxy transactionAwareDataSource() {
        return new TransactionAwareDataSourceProxy(lazyConnectionDataSource());
    }

    @Bean
    public DataSourceTransactionManager transactionManager() {
        return new DataSourceTransactionManager(lazyConnectionDataSource());
    }

    @Bean
    public DataSourceConnectionProvider connectionProvider() {
        return new DataSourceConnectionProvider(transactionAwareDataSource());
    }
    
	@Bean
	public TransactionProvider transactionProvider() {
		return new SpringTransactionProvider();
	}

    @Bean
    public JOOQToSpringExceptionTransformer jooqToSpringExceptionTransformer() {
        return new JOOQToSpringExceptionTransformer();
    }
    
    @Bean
    public DefaultConfiguration configuration() {
        DefaultConfiguration jooqConfiguration = new DefaultConfiguration();

        jooqConfiguration.set(connectionProvider());
        jooqConfiguration.set(new DefaultExecuteListenerProvider(
            jooqToSpringExceptionTransformer()
        ));

        String sqlDialectName = env.getRequiredProperty(PROPERTY_NAME_JOOQ_SQL_DIALECT);
        SQLDialect dialect = SQLDialect.valueOf(sqlDialectName);
        jooqConfiguration.set(dialect);
        jooqConfiguration.set(new Settings().withRenderFormatted(true));
        
        return jooqConfiguration;
    }
    
    @Bean
    public DefaultDSLContext dsl() {
        return new DefaultDSLContext(configuration());
    }
}
