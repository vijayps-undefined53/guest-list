package com.guestlist.guestlist_artifact;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.guestlist")
public class GuestlistArtifactApplication {

	public static void main(String[] args) {
		SpringApplication.run(GuestlistArtifactApplication.class, args);
	}

}
