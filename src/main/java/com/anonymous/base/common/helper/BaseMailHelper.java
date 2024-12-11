package com.anonymous.base.common.helper;

import com.anonymous.base.common.exceptions.BaseCommonException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.mail.internet.MimeMessage;
import java.io.File;
import java.util.List;

/**
 * @author : yangsl25774
 * @Description: MailHelper 邮件发送工具类
 * @date: 2024/12/11 16:29
 */
@Component
public class BaseMailHelper {

    @Autowired
    private JavaMailSender mailSender;

    /**
     * 发送简单的文本邮件。
     *
     * @param from    发件人
     * @param to      收件人
     * @param subject 邮件主题
     * @param text    邮件内容
     * @throws BaseCommonException 如果邮件发送失败抛出异常
     */
    public void sendSimpleMail(String from, String to, String subject, String text) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(from);
        message.setTo(to);
        message.setSubject(subject);
        message.setText(text);
        mailSender.send(message);
    }

    /**
     * 发送 HTML 格式的邮件。
     *
     * @param from    发件人
     * @param to      收件人
     * @param subject 邮件主题
     * @param text    HTML 格式的邮件内容
     * @throws BaseCommonException 如果邮件发送失败抛出异常
     */
    public void sendHtmlMail(String from, String to, String subject, String text) {
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        try {
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
            helper.setFrom(from);
            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(text, true);  // 设置邮件为 HTML 格式
            mailSender.send(mimeMessage);
        } catch (Exception e) {
            throw new BaseCommonException("发送 HTML 邮件失败", e);
        }
    }

    /**
     * 发送带附件的邮件。
     *
     * @param from     发件人
     * @param to       收件人
     * @param subject  邮件主题
     * @param text     邮件内容
     * @param fileName 附件文件名称+后缀
     * @param filePath 附件文件全路径
     * @throws BaseCommonException 如果邮件发送失败抛出异常
     */
    public void sendMailWithFile(String from, String to, String subject, String text, String fileName, String filePath) {
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        try {
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
            helper.setFrom(from);
            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(text);
            helper.addAttachment(fileName, new File(filePath));
            mailSender.send(mimeMessage);
        } catch (Exception e) {
            throw new BaseCommonException("发送带附件的邮件失败", e);
        }
    }

    /**
     * 发送带多个附件的邮件。
     *
     * @param from        发件人
     * @param to          收件人
     * @param subject     邮件主题
     * @param text        邮件内容
     * @param attachments 附件文件路径列表
     * @throws BaseCommonException 如果邮件发送失败抛出异常
     */
    public void sendMailWithFiles(String from, String to, String subject, String text, List<String> attachments) {
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        try {
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
            helper.setFrom(from);
            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(text);
            for (String attachment : attachments) {
                helper.addAttachment(attachment, new File(attachment));
            }
            mailSender.send(mimeMessage);
        } catch (Exception e) {
            throw new BaseCommonException("发送带多个附件的邮件失败", e);
        }
    }

    /**
     * 发送带抄送（CC）和密件抄送（BCC）的邮件。
     *
     * @param from    发件人
     * @param to      收件人
     * @param cc      抄送人
     * @param bcc     密件抄送人
     * @param subject 邮件主题
     * @param text    邮件内容
     * @throws BaseCommonException 如果邮件发送失败抛出异常
     */
    public void sendMailWithCcAndBcc(String from, String to, String[] cc, String[] bcc, String subject, String text) {
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        try {
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
            helper.setFrom(from);
            helper.setTo(to);
            if (cc != null) helper.setCc(cc);
            if (bcc != null) helper.setBcc(bcc);
            helper.setSubject(subject);
            helper.setText(text);
            mailSender.send(mimeMessage);
        } catch (Exception e) {
            throw new BaseCommonException("发送带抄送和密件抄送的邮件失败", e);
        }
    }

    /**
     * 发送 HTML 邮件到多个收件人。
     *
     * @param from    发件人
     * @param to      收件人列表
     * @param subject 邮件主题
     * @param text    邮件内容
     * @throws BaseCommonException 如果邮件发送失败抛出异常
     */
    public void sendHtmlMailToMultipleRecipients(String from, String[] to, String subject, String text) {
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        try {
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
            helper.setFrom(from);
            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(text, true);  // 设置为 HTML 格式
            mailSender.send(mimeMessage);
        } catch (Exception e) {
            throw new BaseCommonException("发送 HTML 邮件到多个收件人失败", e);
        }
    }

    /**
     * 发送带内嵌图片的 HTML 邮件。
     *
     * @param from      发件人
     * @param to        收件人
     * @param subject   邮件主题
     * @param text      邮件内容（可以包含 HTML 标签）
     * @param imagePath 图片文件路径
     * @throws BaseCommonException 如果邮件发送失败抛出异常
     */
    public void sendHtmlMailWithInlineImage(String from, String to, String subject, String text, String imagePath) {
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        try {
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
            helper.setFrom(from);
            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(text, true);  // 设置为 HTML 格式
            helper.addInline("image", new java.io.File(imagePath));  // 添加内嵌图片
            mailSender.send(mimeMessage);
        } catch (Exception e) {
            throw new BaseCommonException("发送带内嵌图片的 HTML 邮件失败", e);
        }
    }
}
