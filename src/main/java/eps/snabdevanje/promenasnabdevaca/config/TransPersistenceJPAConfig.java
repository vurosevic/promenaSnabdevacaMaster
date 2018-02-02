/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eps.snabdevanje.promenasnabdevaca.config;

import java.util.Properties;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import liquibase.integration.spring.SpringLiquibase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.core.io.ResourceLoader;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.util.Assert;

@Configuration
@ComponentScan(basePackages = {"eps.snabdevanje.promenasnabdevaca", "eps.snabdevanje.promenasnabdevaca.repository",
"eps.snabdevanje.promenasnabdevaca.service","eps.snabdevanje.promenasnabdevaca.service.impl",
"eps.snabdevanje.promenasnabdevaca.mb"})
@EnableJpaRepositories("eps.snabdevanje.promenasnabdevaca.repository")
@EnableTransactionManagement
public class TransPersistenceJPAConfig {

    public TransPersistenceJPAConfig() {
        System.out.println("Constructor: public TransPersistenceJPAConfig()");
    }

    @Bean(name = "entityManagerFactory")
    @DependsOn("liquibase")
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        System.out.println("@Bean: public LocalContainerEntityManagerFactoryBean entityManagerFactory()");
        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setPersistenceUnitName("PROMENA_SNABDEVACA_PU");        
        JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        em.setJpaVendorAdapter(vendorAdapter);
        em.setJpaProperties(additionalProperties());
        return em;
    }
    
    @Bean    
    public PlatformTransactionManager transactionManager(EntityManagerFactory emf) {
        System.out.println("@Bean: public PlatformTransactionManager transactionManager(EntityManagerFactory emf)");
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(emf);
        return transactionManager;
    }

    Properties additionalProperties() {
        Properties properties = new Properties();
        //properties.setProperty("hibernate.hbm2ddl.auto", "create-drop");
        properties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
        properties.setProperty("hibernate.show_sql", "true");

        return properties;
    }

    /* liquibase configuration */
    @Autowired
    private ResourceLoader resourceLoader;
    @Autowired
    private DataSource dataSource;

    @Bean          
    public SpringLiquibase liquibase() {
        System.out.println("@Bean SpringLiquibase -----start");

        // Locate change log file
        String changelogFile = "classpath:/liquibase/changelog.xml";
        org.springframework.core.io.Resource resource = resourceLoader.getResource(changelogFile);
        Assert.state(resource.exists(), "Unable to find file: " + changelogFile);

        // Configure Liquibase
        SpringLiquibase liquibase = new SpringLiquibase();
        liquibase.setChangeLog(changelogFile);
        liquibase.setDataSource(dataSource);
        //liquibase.setDropFirst(true);
        liquibase.setShouldRun(true);

        System.out.println("@Bean SpringLiquibase -----end");
        return liquibase;
    }

    @Bean
    public DataSource dataSource() {
        System.out.println("@Bean: public DataSource dataSource()");
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/proba?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&nullNamePatternMatchesAll=true");
        dataSource.setUsername("epss");
        dataSource.setPassword("epss.EPSS");
        return dataSource;
    }     
    
}
