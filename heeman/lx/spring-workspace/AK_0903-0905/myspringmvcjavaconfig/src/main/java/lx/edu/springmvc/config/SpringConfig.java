package lx.edu.springmvc.config;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
//@ComponentScan(basePackages = "lx.edu.springmvc")
//<context:component-scan base-package="myspring"/>

public class SpringConfig {

		@Bean
		DataSource dataSource() {
			BasicDataSource dataSource = new BasicDataSource();
			dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
			dataSource.setUrl("jdbc:mysql://localhost:3306/newhr");
			dataSource.setUsername("root");
			dataSource.setPassword("rootroot");
			return dataSource;
		}
		
		@Bean
		public SqlSessionFactoryBean sqlSessionFactory(ApplicationContext context) throws Exception {
			SqlSessionFactoryBean fatory = new SqlSessionFactoryBean();
			
			// 1. <property name="dataSource" ref="dataSource" />
			fatory.setDataSource(dataSource());	
			
			// 2. <property name="mapperLocations" value="classpath:mapper-*.xml" />
			fatory.setMapperLocations(context.getResources("classpath:mapper-*.xml")); //
			
			// 4. <bean class="org.apache.ibatis.session.Configuration">
			org.apache.ibatis.session.Configuration configuration = new org.apache.ibatis.session.Configuration();

			// 5. <property name="mapUnderscoreToCamelCase" value="true"/>
			configuration.setMapUnderscoreToCamelCase(true);
			
			// 3. <property name="configuration">
			fatory.setConfiguration(configuration);
			return fatory;
		}
 

		@Bean
		public SqlSessionTemplate sqlSession(SqlSessionFactory sqlSessionFactory) { 
			
			// 1. <constructor-arg index="0" ref="sqlSessionFactory"/> 
			SqlSessionTemplate template = new SqlSessionTemplate(sqlSessionFactory);
			return template;
		}
		
}
