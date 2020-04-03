package com.example.mailservice.config;

import com.example.mailservice.model.Job;
import com.example.mailservice.proxy.JobServiceProxy;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

import java.util.List;

@Configuration
@AllArgsConstructor
@Slf4j
public class MailSenderConfig {
    private final JavaMailSender mailSender;
    private final  JobServiceProxy proxy;

    public void sendMail() {
        SimpleMailMessage msg  = new SimpleMailMessage();
        msg.setTo("poudelsagar530@gmail.com");
        msg.setSubject("New Jobs Available");

        log.info(String.valueOf(proxy.getJobs()));
        List<Job> jobs = proxy.getJobs();
        String response = "";
        for(Job j: jobs) {
            response += j.getTitle() + "\n" + j.getCompany() + "\n" + j.getLocation()+ "\n" + j.getLink() + "\n\n";
        }
        msg.setText(response);
        mailSender.send(msg);
    }


}
