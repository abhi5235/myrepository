package com.example.demo;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {
//	 private static final Log logger=LogFactory.getLog(MyController.class);
	 @Autowired
	 ApplicationContext context;
	 @GetMapping("/login")
	 public String loginUser (String username,String password) {
		 if(username.equalsIgnoreCase("jack")) {
//			 logger.info("you are not authenticate");
		return username+ " you are not allowed to login";
	 }
	 else {
//		 logger.info("logging in");
		 return "welcome "+username;
	 }

}
}
