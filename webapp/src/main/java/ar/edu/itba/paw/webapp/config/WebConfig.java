package ar.edu.itba.paw.webapp.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;
import org.springframework.jdbc.datasource.init.DataSourceInitializer;
import org.springframework.jdbc.datasource.init.DatabasePopulator;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@EnableWebMvc
@ComponentScan({ "ar.edu.itba.paw.webapp.controller", "ar.edu.itba.paw.services", "ar.edu.itba.paw.persistence"})
@Configuration
public class WebConfig implements WebMvcConfigurer {
	
	@Value("classpath:db/schema.sql")
	private Resource schemaSql;

	@Bean
	public ViewResolver viewResolver() {
		final InternalResourceViewResolver vr = new InternalResourceViewResolver();

		vr.setPrefix("/WEB-INF/jsp/");
		vr.setSuffix(".jsp");
		vr.setViewClass(JstlView.class);

		return vr;
	}
	
	@Bean
	public DataSource dataSource() {
		final SimpleDriverDataSource ds = new SimpleDriverDataSource();
		
		ds.setDriverClass(org.postgresql.Driver.class);
		ds.setUrl("jdbc:postgresql://localhost/paw");
		ds.setUsername("juampi"); //para probar q ande esto tienen que crear una base de datos local (llamada paw) y en donde dice juampi poner su usuario (y si tienen contrasena ponerla tambien_
		ds.setPassword("");
		
		return ds;
	}
	
	@Bean
	public DataSourceInitializer dsi() {
		
		final DataSourceInitializer dsi = new DataSourceInitializer();
		
		dsi.setDataSource(dataSource());
		dsi.setDatabasePopulator(dataSourcePopulator());
		
		return dsi;
	}
	
	private DatabasePopulator dataSourcePopulator() {
		final ResourceDatabasePopulator dbp = new ResourceDatabasePopulator();
		
		dbp.addScript(schemaSql);
		
		return dbp;
	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/css/**").addResourceLocations("/css/");

		registry.addResourceHandler("/images/**").addResourceLocations("/images/");

		registry.addResourceHandler("/js/**").addResourceLocations("/js/");
	}
}
