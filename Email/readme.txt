该应用程序只适用与163邮箱：
这里的password其实并不是密码，而是授权码--> POP3/IMAP/SMTP/Exchange/CardDAV/CalDAV服务。
配置文件三个重要参数，不能出错，尤其是host-->容易误写成post
		props.put("mail.transport.protocol", "smtp");//邮件传输协议
		props.put("mail.host", "smtp.163.com");//服务主机
		props.put("mail.smtp.auth", true);//密码安全设置
			 