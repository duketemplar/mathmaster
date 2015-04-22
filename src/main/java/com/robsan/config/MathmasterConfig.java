package com.robsan.config;


import org.apache.commons.dbcp.BasicDataSource;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;


import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.sql.DataSource;

/**
 * Created by lordofeverything on 03/01/15.
 */
@Configuration
@PropertySource(value = {"file:/Applications/bin/apache-tomcat-7.0.57/conf/service-mathmaster/jdbc-config.properties"})
@ComponentScan(basePackages = "com.robsan")
public class MathmasterConfig {

    final static Logger LOGGER = Logger.getLogger(MathmasterConfig.class);

    @Inject
    private Environment environment;

    @Autowired
    ApplicationContext context;



    @PostConstruct
    public void init(){

        LOGGER.info("JDBC setup: "+environment.getProperty("jdbc.oracle.host"));
    }

    @Bean(name = "oracleDataSource")
    public DataSource setDataSource() {
        final BasicDataSource ds = new BasicDataSource();
        ds.setDriverClassName("oracle.jdbc.driver.OracleDriver");
        ds.setUrl(environment.getProperty("jdbc.oracle.host"));
        ds.setUsername(environment.getProperty("jdbc.oracle.username"));
        ds.setPassword(environment.getProperty("jdbc.oracle.password"));
        return ds;
    }

    @Bean(name = "oracleJdbcTemplate")
    public JdbcTemplate getJdbcTemplate() {
        return new JdbcTemplate((DataSource) context.getBean("oracleDataSource"));
    }







}
