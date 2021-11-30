package base;

import java.io.File;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.SimpleEmail;

public class SendEmail {

	public static void mailSend() throws Exception {
		final String username = "dinesh.kanna@pegs.com";
		final String password = "Disser@01";
		String fromEmail = "dinesh.kanna@pegs.com";
		String toEmail = "dinesh.kanna@pegs.com";

		EmailAttachment attachment=new EmailAttachment();
		attachment.setPath("C:\\Users\\Dinesh.Kanna\\eclipse-workspace\\IGT\\allure-results.zip");
		
		Properties p = new Properties();
		p.put("mail.smtp.host", "smtp.gmail.com");
		p.put ("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");
		p.put("mail.smtp.starttls.enable", "true");
		p.put("mail.smtp.auth", "true");
		p.put("mail.smtp.port", "465");
		// authentication with Session class
		Session s= Session.getDefaultInstance(p, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});

		Message m = new MimeMessage(s);
		try {
			m.setFrom(new InternetAddress(fromEmail));
			m.addRecipient(Message.RecipientType.TO,new InternetAddress(toEmail));
			m.setSubject("Email Report");
			m.setText("New Mail");

//			Date dt=new Date();
//			SimpleDateFormat format=new SimpleDateFormat("MM/dd/yyyy");
//			String stDate=format.format(dt);
			//
			//			m.setSubject("Execution report on"+stDate);
			BodyPart messageBodyPart=new MimeBodyPart();
			messageBodyPart.setText("Hi \n"
					+ "Updated reports are attached. Kindly check..");
			Multipart multipart= new MimeMultipart();
			multipart.addBodyPart(messageBodyPart);

			File file=new File("C:\\Users\\Dinesh.Kanna\\eclipse-workspace\\FrameworkIGT\\test-output\\emailable-report.html");

			messageBodyPart = new MimeBodyPart();
			DataSource source=new FileDataSource(file.getAbsolutePath());
			messageBodyPart.setDataHandler(new DataHandler(source));
			messageBodyPart.setFileName("Report ");
			multipart.addBodyPart(messageBodyPart);
			m.setContent(multipart);
			Transport.send(m);

		} catch (AddressException e) {
			e.printStackTrace();
		}
	}
}
