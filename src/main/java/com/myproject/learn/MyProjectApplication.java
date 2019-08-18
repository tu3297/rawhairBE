package com.myproject.learn;

import java.util.TimeZone;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

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
