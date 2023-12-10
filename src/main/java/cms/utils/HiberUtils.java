package cms.utils;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import cms.entities.Course;

//this is utility class Obtaining SessionFactory
public class HiberUtils {

	public static SessionFactory getSessionFactory() {
		
		System.out.println("Configaration Hibernate Programmatically");
		
		
		//making object of Configuration class to configure all Properties
		Configuration hibernateConfig = new Configuration();
		
		//This step is Specifying th Entity Class
		Class<Course> entityClass = Course.class;
		
		//Adding EntityClass in Configuration using addAnnotedClass
		//This is Equivalent to <mapping resource = "Course.hbm.xml">
		hibernateConfig.addAnnotatedClass(entityClass);
		
		//specifyng the Properties
		Properties hibernateProps = new Properties();
		
		hibernateProps.put("hibernate.connection.driver_class","com.mysql.cj.jdbc.Driver");
		hibernateProps.put("hibernate.connection.url","jdbc:mysql://localhost:3306/cdachibernate");
		hibernateProps.put("hibernate.connection.username","root");
		hibernateProps.put("hibernate.connection.password","123456");
		
		hibernateProps.put("hibernate.dialect","org.hibernate.dialect.MySQL8Dialect");
		hibernateProps.put("hibernate.show_sql","true");
		hibernateProps.put("hibernate.hbm2ddl.auto","update");
		
		hibernateConfig.setProperties(hibernateProps);
		
		SessionFactory hibernateFactory = hibernateConfig.buildSessionFactory();
		return hibernateFactory;
		
		
		
		
		
	}
}
