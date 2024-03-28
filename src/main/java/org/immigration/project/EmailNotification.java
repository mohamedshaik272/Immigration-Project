package org.immigration.project;

public class EmailNotification {
    public void sendEmail(String email, String message) {
        send(email, message);
    }

    public void send(String email, String message) {
        System.out.println("Email sent to " + email + " with message: " + message);
    }
}

