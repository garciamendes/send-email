package com.gg.email_service.applications;

import com.gg.email_service.adpters.EmailSenderGateway;
import com.gg.email_service.core.EmailSendUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmailSendService implements EmailSendUseCase {
    private final EmailSenderGateway emailSenderGateway;

    @Autowired
    public EmailSendService(EmailSenderGateway emailSenderGateway) {
        this.emailSenderGateway = emailSenderGateway;
    }

    @Override
    public void sendEmail(String to, String subject, String body) {
        this.emailSenderGateway.sendEmail(to, subject, body);
    }
}
