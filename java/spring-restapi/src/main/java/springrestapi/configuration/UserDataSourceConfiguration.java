package springrestapi.configuration;

import java.util.Properties;
import javax.sql.DataSource;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
@EnableJpaRepositories(
    entityManagerFactoryRef = "userEntityManager",
    transactionManagerRef = "userTransactionManager",
    basePackages = {"springrestapi.repositories.users"}
)
public class UserDataSourceConfiguration {
    @Bean
    @ConfigurationProperties(prefix = "spring.users-datasource")
    public DataSource userDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean userEntityManager() {
        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();

        em.setDataSource(userDataSource());
        em.setPackagesToScan("springrestapi.domain.user");

        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        em.setJpaVendorAdapter(vendorAdapter);

        Properties properties = new Properties();
        properties.put("hibernate.hbm2ddl.auto", "update");
        properties.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");

        em.setJpaProperties(properties);

        return em;
    }

    // @Bean
    // public LocalContainerEntityManagerFactoryBean productEntityManager() {
    //     LocalContainerEntityManagerFactoryBean em
    //         = new LocalContainerEntityManagerFactoryBean();
    //     em.setDataSource(productDataSource());
    //     em.setPackagesToScan(
    //         new String[] { "com.baeldung.multipledb.model.product" });

    //     HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
    //     em.setJpaVendorAdapter(vendorAdapter);
    //     HashMap<String, Object> properties = new HashMap<>();
    //     properties.put("hibernate.hbm2ddl.auto",
    //         env.getProperty("hibernate.hbm2ddl.auto"));
    //     properties.put("hibernate.dialect",
    //         env.getProperty("hibernate.dialect"));
    //     em.setJpaPropertyMap(properties);

    //     return em;
    // }

    @Bean
    public PlatformTransactionManager userTransactionManager() {
        JpaTransactionManager transactionManager = new JpaTransactionManager();

        transactionManager.setEntityManagerFactory(userEntityManager().getObject());

        return transactionManager;
    }
}
