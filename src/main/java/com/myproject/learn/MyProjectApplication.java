package com.myproject.learn;

import java.util.TimeZone;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.myproject.learn.model.Role;
import com.myproject.learn.model.RoleName;
import com.myproject.learn.repository.RoleRepository;

@SpringBootApplication
public class MyProjectApplication implements CommandLineRunner {
	
	
	@Autowired
	private RoleRepository roleRepo;
	@PostConstruct
	void init() {
		TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
	}
	public static void main(String[] args) {
		SpringApplication.run(MyProjectApplication.class, args);
	}
	  @Configuration
	    public class WebConfig implements WebMvcConfigurer {      
	        @Override
	        public void addResourceHandlers(ResourceHandlerRegistry registry) {
	            registry.addResourceHandler("/**")
	            .addResourceLocations("classpath:/static/","classpath:/images/")
	            .setCachePeriod(0);
	        }
	    }
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		try {
//		roleRepo.save(new Role(RoleName.ROLE_USER));
//		roleRepo.save(new Role(RoleName.ROLE_ADMIN));
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}

}
