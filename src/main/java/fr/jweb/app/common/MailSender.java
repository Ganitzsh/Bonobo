package fr.jweb.app.common;

import javax.mail.*;
import javax.mail.internet.*;

import org.apache.log4j.Logger;

import java.util.*;

public class MailSender {
	
	private static final Logger logger = Logger.getLogger(MailSender.class);

	private static final String HOST = "smtp.gmail.com";
	private static final String FROM = "julien.ganichot@gmail.com";
	private static final String PASS = "d.g*4([h";
	
    private Properties props = System.getProperties();
  
    public Properties getProps() {
		return props;
	}

	public void setProps(Properties props) {
		this.props = props;
	}
	
	public MailSender() {
		props.put("mail.smtp.starttls.enable", "true");
	    props.put("mail.smtp.host", HOST);
	    props.put("mail.smtp.user", FROM);
	    props.put("mail.smtp.password", PASS);
	    props.put("mail.smtp.port", "587");
	    props.put("mail.smtp.auth", "true");
	}

	public void sendMail(String object, String content, String[] targets) {
		try {
		    String[] to = targets;

		    Session session = Session.getDefaultInstance(props, null);
		    MimeMessage message = new MimeMessage(session);
		    message.setFrom(new InternetAddress(FROM));
		    InternetAddress[] toAddress = new InternetAddress[to.length];
		    for (int i = 0 ; i < to.length ; i++) {
		        toAddress[i] = new InternetAddress(to[i]);
		    }
		    logger.info("Sending message to: " + Message.RecipientType.TO);
		    for (int i = 0 ; i < toAddress.length ; i++) {
		        message.addRecipient(Message.RecipientType.TO, toAddress[i]);
		    }
		    message.setSubject(object);
		    message.setText(content);
		    Transport transport = session.getTransport("smtp");
		    transport.connect(HOST, FROM, PASS);
		    transport.sendMessage(message, message.getAllRecipients());
		    transport.close();
		} catch(Exception e){
			logger.error("Failed to send mail: " + e.getMessage());
            e.printStackTrace();
        }	
	}
}
