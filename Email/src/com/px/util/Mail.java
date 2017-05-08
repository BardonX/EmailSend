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
 * @Description: �ʼ�Ⱥ��������
 * @author: Bardon
 * @date: 2017��5��7�� ����9:35:40
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
			//���ղ���
			String name=req.getParameter("m_name");
			String topic=req.getParameter("m_topic");
			//����
			String con=req.getParameter("c_con");
			
			//�˻� �û��� ��Ȩ��
			String username="13545254244@163.com";
			String password="1757emailpj";
			
			//����һ������������ȡ����������ļ�
			Properties props=new Properties();
			props.put("mail.transport.protocol", "smtp");//�ʼ�����Э��
			props.put("mail.host", "smtp.163.com");//��������
			props.put("mail.smtp.auth", true);//���밲ȫ����
			 
			Session session=Session.getInstance(props);
			//����һ������Ŀͻ���
			MimeMessage ms=new MimeMessage(session);
			//�����ʼ���Դ
			Address toaddress=new InternetAddress(username);
			ms.setFrom(toaddress);
			//������
			ms.setRecipients(Message.RecipientType.BCC, name);
			ms.setSubject(topic);
			ms.setText(con);
			ms.saveChanges();
			
			//�������͹���
			Transport ts=session.getTransport();
			ts.connect(username,password);
			ts.sendMessage(ms, ms.getAllRecipients());
			ts.close();
			
			//��֤
			PrintWriter pw=resp.getWriter();
			pw.print("���ͳɹ�");
			
		} catch (Exception e) {
			e.printStackTrace();
		}			
	}

}
