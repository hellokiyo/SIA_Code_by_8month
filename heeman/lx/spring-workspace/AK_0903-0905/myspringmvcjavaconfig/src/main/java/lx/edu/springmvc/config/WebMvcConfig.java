package lx.edu.springmvc.config;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import lx.edu.springmvc.interceptor.LoginInterceptor;

@Configuration
@EnableWebMvc
@ComponentScan("lx.edu.springmvc")
public class WebMvcConfig implements WebMvcConfigurer {

    private final SqlSessionFactoryBean sqlSessionFactory;

    WebMvcConfig(SqlSessionFactoryBean sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }

	@Bean
	public InternalResourceViewResolver jspResolver() {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/views/");
		resolver.setSuffix(".jsp");
		return resolver;
	}
//<interceptors>
//	<interceptor>
//		<mapping path="/addrbook_list.do"/>
//		<mapping path="/insert.do"/>
//		<beans:bean class="lx.edu.springmvc.interceptor.LoginInterceptor"></beans:bean>
//	</interceptor> 
//</interceptors>
	
	@Bean
	public LoginInterceptor loginInterceptor() {
		return new LoginInterceptor();
	}
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(loginInterceptor())
				.addPathPatterns("/addrbook_list.do","/insert.do"); //가변인자라서 몇개를 넣어도 가능 <스프링에서 함수 만들때 가변인자로 만들어놈
		
	}
	
	
	
	
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
	}
	
	
	
}
