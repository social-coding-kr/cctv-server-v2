package com.socialcoding;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.system.ApplicationPidFileWriter;

@SpringBootApplication
public class CctvApiApplication {

	private static final String PID_FILE_NAME = "cctv-api-server.pid";

	public static void main(String[] args) {
		SpringApplication application = new SpringApplication(CctvApiApplication.class);
		application.addListeners(new ApplicationPidFileWriter(PID_FILE_NAME));
		application.run(args);
	}

}
