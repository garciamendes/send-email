package com.gg.email_service.adpters;

public interface EmailSenderGateway {
    void sendEmail (String to, String subject, String body);
}
