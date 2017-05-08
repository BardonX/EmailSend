package com.px.util;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Properties;

import javax.mail.Address;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 
 * @ClassName: Mail
 * @Description: 邮件群发核心类
 * @author: Bardon
 * @date: 2017年5月7日 上午9:35:40
 * @version1.0
 */
public class Mail extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		try {
			req.setCharacterEncoding("utf-8");
			resp.setContentType("text/html;charset=utf-8");
			//接收参数
			String name=req.getParameter("m_name");
			String topic=req.getParameter("m_topic");
			//正文
			String con=req.getParameter("c_con");
			
			//账户 用户名 授权码（授权码已做隐藏）
			String username="13545254244@163.com";
			String password="1757email**";
			
			//创建一个对象用来读取邮箱的配置文件
			Properties props=new Properties();
			props.put("mail.transport.protocol", "smtp");//邮件传输协议
			props.put("mail.host", "smtp.163.com");//服务主机
			props.put("mail.smtp.auth", true);//密码安全设置
			 
			Session session=Session.getInstance(props);
			//创建一个邮箱的客户端
			MimeMessage ms=new MimeMessage(session);
			//设置邮件来源
			Address toaddress=new InternetAddress(username);
			ms.setFrom(toaddress);
			//接收者
			ms.setRecipients(Message.RecipientType.BCC, name);
			ms.setSubject(topic);
			ms.setText(con);
			ms.saveChanges();
			
			//创建发送工具
			Transport ts=session.getTransport();
			ts.connect(username,password);
			ts.sendMessage(ms, ms.getAllRecipients());
			ts.close();
			
			//验证
			PrintWriter pw=resp.getWriter();
			pw.print("发送成功");
			
		} catch (Exception e) {
			e.printStackTrace();
		}			
	}

}
