package com.example.springbootprofiles;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.StandardEnvironment;

@SpringBootApplication
public class SpringBootProfilesApplication {

	public static void main(String[] args) {

		//SpringApplication.run(SpringBootProfilesApplication.class, args);
//		SpringApplication application = new SpringApplication(SpringBootProfilesApplication.class);

		//Set Active Profiles Programmatically using SpringApplication.setAdditionalProfiles(...)
		//We can set active profiles programmatically using SpringApplication.setAdditionalProfiles(...) as follows.
		//MyApplication.java
//		application.setAdditionalProfiles("dev","animal_dev");
//		application.run(args);

		//Set Active Profiles Programmatically using ConfigurableEnvironment.setActiveProfiles(...)
		//We can set active profiles programmatically using ConfigurableEnvironment.setActiveProfiles(...).
		//MyApplication.java
//		ConfigurableEnvironment environment = new StandardEnvironment();
//		environment.setActiveProfiles("dev","animal_dev");
//		application.setEnvironment(environment);
//		application.run(args);


		//Set Default Profiles
		//There should be a default profile that should be loaded if no profile is enabled. We can set default profile that will be used by spring boot application when we have not configured any active profile.
		//We can set default profiles using setDefaultProfiles(...) method of ConfigurableEnvironment as follows.
		//MyApplication.java
//		ConfigurableEnvironment environment = new StandardEnvironment();
//		environment.setDefaultProfiles("dev","animal_dev");
//		application.setEnvironment(environment);
//		application.run(args);

		SpringApplication.run(SpringBootProfilesApplication.class, args);
	}

}
