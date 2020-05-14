package cs544.project.controller;

import java.io.IOException;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cs544.project.service.EmailService;

@RestController
public class EmailController {
	
	@Autowired
	private EmailService service;
	
   @RequestMapping(value = "/sendemail")
   public String sendEmail() {
	   try {
		   System.out.println("1");
		   service.sendmail();
	} catch (MessagingException | IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	   System.out.println("4");
	   return "Email sent successfully"; 
   }  
   
   
}