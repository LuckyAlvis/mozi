package com.dai.common.utils.mail;

import javax.mail.Address;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Date;
import java.util.Properties;

public class MZMailUtils {


    public static void sendJMToolMail(String subject,String text) throws Exception {
        String myEmailAccount = "252127196@qq.com"; // 发件人邮箱地址
        String myEmailPassword = "swmecvmlqcprbjfd"; // 发件人邮箱密码
        String myEmailSMTPHost = "smtp.qq.com"; // 发件人邮箱服务器协议
        String receiveMailAccount = "ivan.dai@nf-3.com"; //收件人邮箱数组
        String mailTransportProtocol = "smtp"; // 使用的协议（JavaMail规范要求）
        String senderPersonalName = "JMTool上线告警助手"; // 发件人昵称
        Properties props = new Properties();
        props.setProperty("mail.transport.protocol", mailTransportProtocol);
        props.setProperty("mail.smtp.host", myEmailSMTPHost);   // 发件人的邮箱的 SMTP 服务器地址
        props.setProperty("mail.smtp.auth", "true");            // 需要请求认证
        Session session = Session.getInstance(props);
        // 设置为debug模式, 可以查看详细的发送 log
        session.setDebug(false);
        MimeMessage message = createMimeMessage(senderPersonalName, session, myEmailAccount, receiveMailAccount);

        // 4. 根据 Session 获取邮件传输对象
        Transport transport = session.getTransport();
        transport.connect(myEmailAccount, myEmailPassword);

        // 6. 发送邮件, 发到所有的收件地址, message.getAllRecipients() 获取到的是在创建邮件对象时添加的所有收件人, 抄送人, 密送人
        transport.sendMessage(message, message.getAllRecipients());
        transport.close();
    }

    public static void main(String[] args) throws Exception {
        sendJMToolMail("JMTOOL主题","JMTOOL告警测试");
    }

    public static MimeMessage createMimeMessage(String senderPersonalName, Session session, String sendMail, String receiveMailAddress) throws Exception {
        // 1. 创建一封邮件
        MimeMessage message = new MimeMessage(session);
        // 2. From: 发件人
        message.setFrom(new InternetAddress(sendMail, senderPersonalName, "UTF-8"));
        // 3. To: 收件人（可以增加多个收件人、抄送、密送）
        Address[] internetAddressTo = InternetAddress.parse(receiveMailAddress);
        message.setRecipients(MimeMessage.RecipientType.TO, internetAddressTo);
        // 4. Subject: 邮件主题
        message.setSubject("JMTool商场数据上线异常，请及时排查", "UTF-8");
        // 5. Content: 邮件正文（可以使用html标签）
        message.setContent("JMTOOL告警测试", "text/html;charset=UTF-8");
        // 6. 设置发件时间
        message.setSentDate(new Date());
        // 7. 保存设置
        message.saveChanges();
        return message;
    }
}
