package base;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.mail.Store;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.mail.Flags;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.Session;

import com.testing.framework.EmailUtils;

public class Email_OTP {
	
//	String hostName = "smtp.gmail.com";
//	String username = "dinesh.kanna@pegs.com";
//	String password = "Disser@01";
//	int messageCount;
//	int unreadMsgCount;
//	String emailSubject;
//	Message emailMessage;
//	
//	public void email() {
//	 Properties sysProps = System.getProperties();
//	    sysProps.setProperty("mail.store.protocol", "imaps");
//
//	    try {
//	        Session session = Session.getInstance(sysProps, null);
//	        Store store = session.getStore();
//	        store.connect(hostName, username, password);
//	        Folder emailInbox = store.getFolder("INBOX");
//	        emailInbox.open(Folder.READ_WRITE);
//	        messageCount = emailInbox.getMessageCount();
//	        System.out.println("Total Message Count: " + messageCount);
//	        unreadMsgCount = emailInbox.getNewMessageCount();
//	        System.out.println("Unread Emails count:" + unreadMsgCount);
//	        emailMessage = emailInbox.getMessage(messageCount);
//	        emailSubject = emailMessage.getSubject();
//
//	        Pattern linkPattern = Pattern.compile("href=\"(.*)\" target"); // here you need to define regex as per you need
//	        Matcher pageMatcher =
//	                linkPattern.matcher(emailMessage.getContent().toString());
//
//	        while (pageMatcher.find()) {
//	            System.out.println("Found OTP " + pageMatcher.group(1));
//	        }
//	        emailMessage.setFlag(Flags.Flag.SEEN, true);
//	        emailInbox.close(true);
//	        store.close();
//
//	    } catch (Exception mex) {
//	        mex.printStackTrace();
//	    }
//	}
	
	
	static Properties prop;
	
	public static String emailOTP() throws Exception {
		EmailUtils emailutils = new EmailUtils();
		prop = new Properties();
		FileInputStream ip = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\main\\java\\config\\Configuration.properties");
		prop.load(ip);
		Store connection = emailutils.connectToGmail(prop);

		String value = null;
		 Thread.sleep(60000);
		
		List<String> emailtext =emailutils.getUnreadMessageByFromEmail(connection, "Inbox", "noreply@pegs.com",
					"OTP For Authentication");

			System.out.println(emailutils.getUnreadMessageByFromEmail(connection, "Inbox", "noreply@pegs.com",
					"OTP For Authentication")+"@@@@@@@");
			System.out.println("********"+emailtext);
			
			String regex = "[^\\d]+";
			String[] otp = emailtext.get(0).split(regex);
			value = otp[1];
			System.out.println("******** OTP is obtained : ");
			
			String name = System.console().readLine();
	        System.out.println(name);
			
//			if (emailtext.size() < 1) {
//				
//				String regex = "[^\\d]+";
//				String[] otp = emailtext.get(0).split(regex);
//				value = otp[1];
//				System.out.println("******** OTP is obtained : ");
//			} else {
//				System.out.println("No Email recieved");
//			}
		
		return value;
	}

}
