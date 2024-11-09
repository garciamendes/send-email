package com.gg.email_service.infra.ses;

import com.gg.email_service.adpters.EmailSenderGateway;
import com.gg.email_service.core.exceptions.EmailServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import software.amazon.awssdk.services.ses.SesClient;
import software.amazon.awssdk.services.ses.model.*;

@Service
public class SesEmailSender implements EmailSenderGateway {
    private final SesClient sesClient;

    @Autowired
    public SesEmailSender(SesClient sesClient) {
        this.sesClient = sesClient;
    }

    @Override
    public void sendEmail(String to, String subject, String body) {
        try {
            SendEmailRequest request = SendEmailRequest.builder()
                    .destination(Destination.builder().toAddresses(to).build())
                    .message(Message.builder()
                            .subject(Content.builder().data(subject).build())
                            .body(Body.builder()
                                    .text(Content.builder().data(body).build())
                                    .build())
                            .build())
                    .source("garciaprog0101@gmail.com")
                    .build();

            this.sesClient.sendEmail(request);
        } catch (SesException exception) {
            throw new EmailServiceException("Fail send email", exception);
        }
    }
}
