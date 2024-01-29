package lk.ijse.dep11.edupanel;

import com.zaxxer.hikari.HikariDataSource;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.web.context.annotation.RequestScope;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


@Configuration
@PropertySource("classpath:/application.properties")
public class WebRootConfig {

    @Autowired
    private Environment env;
    @Bean
    public HikariDataSource dataSource(){
        HikariDataSource hikariDataSource = new HikariDataSource();
        hikariDataSource.setJdbcUrl(env.getRequiredProperty("spring.datasource.url"));
        hikariDataSource.setUsername(env.getRequiredProperty("spring.datasource.username"));
        hikariDataSource.setPassword(env.getRequiredProperty("spring.datasource.password"));
        hikariDataSource.setDriverClassName(env.getRequiredProperty("spring.datasource.driver-class-name"));
        hikariDataSource.setMaximumPoolSize(env.getRequiredProperty("spring.datasource.hikari.maximum-pool-size", Integer.class));
        return hikariDataSource;

    }
    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean(){
        LocalContainerEntityManagerFactoryBean lcemfb = new LocalContainerEntityManagerFactoryBean();
        lcemfb.setPackagesToScan("lk.ijse.dep11.edupanel.entity");
        lcemfb.setDataSource(dataSource());
        lcemfb.setJpaVendorAdapter(jpaVendorAdapter());
        return lcemfb;
    }
    private JpaVendorAdapter jpaVendorAdapter(){
        HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
        adapter.setShowSql(true);
        adapter.setGenerateDdl(true);
        return adapter;
    }

    @Bean
    public PlatformTransactionManager transactionManager(EntityManagerFactory emf){
        return new JpaTransactionManager(emf);
    }


//    @Bean(destroyMethod = "close")
//    @RequestScope
//    public EntityManager entityManager(){
//
//        return entityManagerFactory().createEntityManager();
//    }

    @Bean
    public ModelMapper modelMapper(){

        return new ModelMapper();
    }
}
