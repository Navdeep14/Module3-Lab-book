package org.cap.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@EnableWebMvc
@ComponentScan("org.cap")
@EnableTransactionManagement
@PropertySource("classpath:orm.properties")
public class MyWebMVCConfig {
    private static Logger Log = LoggerFactory.getLogger(MyWebMVCConfig.class);

    @Autowired
    private ApplicationContext applicationContext;

    @Bean
    public ViewResolver getViewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/pages/");
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }


    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(dataSource());
        em.setPackagesToScan("org.cap");
        JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        em.setJpaVendorAdapter(vendorAdapter);
        em.setJpaProperties(ormProperties());
        return em;
    }


    @Bean
    public DataSource dataSource() {
        try {
            ComboPooledDataSource dataSource = new ComboPooledDataSource();
            Environment environment = applicationContext.getEnvironment();
            String driver = environment.getProperty("driver");
            dataSource.setDriverClass(driver);
            String url = environment.getProperty("url");
            dataSource.setJdbcUrl(url);
            String user = environment.getProperty("user");
            dataSource.setUser(user);
            String password = environment.getProperty("password");
            dataSource.setPassword(password);
            return dataSource;
        } catch (Throwable e) {
            Log.error("exception in oracleDataSource()", e);
            return null;
        }
    }

    Properties ormProperties() {
        Properties properties = new Properties();
        Environment environment = applicationContext.getEnvironment();
        String dialect = environment.getProperty("hibernate.dialect");
        String ddlAuto = environment.getProperty("hibernate.hbm2ddl.auto");
        String showSql = environment.getProperty("hibernate.show_sql");
        properties.setProperty("hibernate.dialect", dialect);
        properties.setProperty("hibernate.hbm2ddl.auto", ddlAuto);
        properties.setProperty("hibernate.show_sql", showSql);
        //  properties.setProperty("spring.jpa.properties.hibernate.jdbc.lob.non_contextual_creation", "true");
        return properties;
    }


    @Bean
    public PlatformTransactionManager transactionManager(
            EntityManagerFactory emf) {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(emf);
        return transactionManager;
    }

    @Bean
    public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
        return new PersistenceExceptionTranslationPostProcessor();
    }


}
