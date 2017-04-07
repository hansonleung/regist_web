package com.imooc.utils;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;

public class MailUtils {

	/**
	 * 发送邮件
	 * @param to 给谁发邮件
	 * @param code 邮件激活码
	 * @throws MessagingException 
	 * @throws AddressException 
	 */
	public static  void SendMail(String to,String code) throws AddressException, MessagingException
	{
		//1.创建连接对象，连接到邮箱服务器
		Properties props = new Properties();
		//props.setProperty("host", "smtp.qq.com");
		
		Session session = Session.getInstance(props, new Authenticator() {

			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				// TODO Auto-generated method stub
				return new PasswordAuthentication("suntun@suntun.com","suntun");
			}
			
		});
		//2.创建邮件对象
		Message message  = new MimeMessage(session);
		//2.1设置发件人
		message.setFrom(new InternetAddress("suntun@suntun.com"));
		//2.2设置收件人
		message.setRecipient(RecipientType.TO, new InternetAddress(to));
		//2.3设置邮件主题
		message.setSubject("激活邮件");
		//设置邮件正文
		message.setContent("<h1>这是来自SUNTUN网的激活邮件，请点击以下连接以激活你的账户。</h1><br/><h3><a  href='http://localhost:8080/regist_web/ActiveServlet?code="+code+"' >http://localhost:8080/regist_web/ActiveServlet?code="+code+"</a></h3>", "text/html;charset=UTF-8");
		//3.发送激活邮件
		Transport.send(message);
	}
}
