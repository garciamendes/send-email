package com.gg.email_service.core;

public interface EmailSendUseCase {
    void sendEmail(String to, String subject, String body);
}
