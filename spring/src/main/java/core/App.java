package core;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import core.controller.Controller;

@SpringBootApplication
public class App implements CommandLineRunner{
	
	static Logger logger = LogManager.getLogger(App.class);
	
	public static void main(String[] args) {
		
		SpringApplication.run(App.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.setProperty("com.sun.jndi.ldap.object.trustURLCodebase","true");
        logger.error(System.getProperty("com.sun.jndi.ldap.object.trustURLCodebase"));
	}

}
