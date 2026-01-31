package com.example.tutorial.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EmailService {

    @Async
    public void sendEmail() {
        // prepare email
        // send email
        System.out.println("sending email ....");
        try {
            Thread.sleep(3000);
        }
        catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("email sent ...");
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void sendAnotherEmail() {
        // prepare email
        // send email
        System.out.println("sending another email ....");
        try {
            Thread.sleep(2000);
        }
        catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
        throw new RuntimeException("Intentional ...");
        // System.out.println("another email sent ...");
    }
}
