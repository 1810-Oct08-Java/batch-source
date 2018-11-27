package com.revature.main;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.client.RestTemplate;

import com.revature.models.User;

public class Driver {
	
	private static final Logger log = LoggerFactory.getLogger(Driver.class);

	public static void main(String[] args) {
		String getRequestUrl = "http://192.168.51.18:8084/users/10";
		
		
		//RestTemplate provided by Spring Web, allows us to send HTTP requests with Java Applications
		RestTemplate restTemplate = new RestTemplate();
		
		try {
			User user = restTemplate.getForObject(getRequestUrl, User.class);
			log.info("resource consumption successful!");
			log.info(user.toString());
		} catch (Exception e) {
			log.error("resource consumption unsuccessful");
		}
		
		
		String postRequestUrl = "http://192.168.51.18:8084/users";
		User newUser = new User(10,"Paulina","Mahan","pmahan@gmail.com","pmahan","secretpass");
		
//		try {
//			User addedUser = restTemplate.postForObject(postRequestUrl, newUser, User.class);
//			log.info("resource exchange successful");
//			log.info("posted: "+newUser.toString());
//		} catch (Exception e) {
//			log.error("resource exchange unsuccessful");
//		}
		
		
		

	}

}
