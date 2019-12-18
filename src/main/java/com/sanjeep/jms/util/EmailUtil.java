package com.sanjeep.jms.util;

import java.io.File;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

@Component
public class EmailUtil {
	private  String EMAIL_BODY = "Please find your Itienary attached";
	private  String EMAIL_SUBJECT = "Itienary for your Flight";
	@Autowired
	private JavaMailSender sender;
	public void sendItenary(String toAddress, String filePath) {
		MimeMessage message = sender.createMimeMessage();
		try {
			MimeMessageHelper messegaHelper=new MimeMessageHelper(message,true);
			messegaHelper.setTo(toAddress);
			messegaHelper.setSubject(EMAIL_SUBJECT);
			messegaHelper.setText(EMAIL_BODY );
			messegaHelper.addAttachment("Iteinary", new File(filePath));
			sender.send(message);
			
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
