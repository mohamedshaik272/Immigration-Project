package org.immigration.project;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import static org.mockito.Mockito.times;

class EmailNotificationTest {

    private EmailNotification emailNotification;
    private EmailNotification mockEmailNotification;

    @BeforeEach
    void setUp() {
        emailNotification = new EmailNotification();
        mockEmailNotification = Mockito.spy(emailNotification);
    }

    @Test
    void testSendEmail() {
        String email = "test@example.com";
        String message = "Hello, this is a test email.";

        // Call the method to test
        mockEmailNotification.sendEmail(email, message);

        // Verify that the send method was called with the right arguments
        Mockito.verify(mockEmailNotification, times(1)).send(email, message);
    }
}
