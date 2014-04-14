package graandy.com.config;

import java.util.List;
import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@EnableWebMvc
@ComponentScan({"graandy.com.controller","graandy.com.dao", "graandy.com.entity"})
@EnableTransactionManagement
public class WebConfig extends WebMvcConfigurerAdapter {
	@Override
	public void configureMessageConverters(
			List<HttpMessageConverter<?>> converters) {
		super.configureMessageConverters(converters);
		converters.add(new JsonMessageConverter());
	}


@Bean
public DataSource dataSource() {
	SimpleDriverDataSource ds = new SimpleDriverDataSource(org.h2.Driver.load(),"jdbc:h2:/github/testdb", "sa", "sa");
	return ds;
}

@Bean
@DependsOn("dataSource")
public LocalSessionFactoryBean sessionFactoryBean(){
	LocalSessionFactoryBean sessionFactoryBean = new LocalSessionFactoryBean();
	sessionFactoryBean.setDataSource(dataSource());
	sessionFactoryBean.setPackagesToScan("graandy.com.entity");
	sessionFactoryBean.setHibernateProperties(hibernateProperties());
	return sessionFactoryBean;
}

public Properties hibernateProperties(){
	Properties p = new Properties();
	p.setProperty("hibernate.dialect","org.hibernate.dialect.H2Dialect");
	p.setProperty("hibernate.hbm2ddl.auto", "update"); // потом убрать
	return p;
}

@Bean
@DependsOn("sessionFactoryBean")
public PlatformTransactionManager transactionManager(){
	SessionFactory sessionFactory = sessionFactoryBean().getObject();
	HibernateTransactionManager tm = new HibernateTransactionManager(sessionFactory);
	return tm;
}

}