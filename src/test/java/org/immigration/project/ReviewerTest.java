package org.immigration.project;

import org.immigration.project.*;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

class ReviewerTest {

    private final int reviewerID = 1;
    private final String name = "John Doe";
    private final String email = "johndoe@example.com";
    private Reviewer reviewer;

    // Prepare to capture output for testing print statements
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    void setUp() {
        // Redirect System.out to capture print statements
        System.setOut(new PrintStream(outputStreamCaptor));
        reviewer = new Reviewer(reviewerID, name, email);
    }

    @Test
    void testReviewerConstructor() {
        assertAll(
                () -> assertEquals(reviewerID, reviewer.getReviewerID(), "Reviewer ID should be set correctly"),
                () -> assertEquals(name, reviewer.getName(), "Name should be set correctly"),
                () -> assertEquals(email, reviewer.getEmail(), "Email should be set correctly")
        );
    }

    @Test
    void testReviewerGetters() {
        assertAll(
                () -> assertEquals(reviewerID, reviewer.getReviewerID(), "getReviewerID should return the correct ID"),
                () -> assertEquals(name, reviewer.getName(), "getName should return the correct name"),
                () -> assertEquals(email, reviewer.getEmail(), "getEmail should return the correct email")
        );
    }

    @Test
    void testReviewerSetters() {
        int newReviewerID = 2;
        String newName = "Jane Doe";
        String newEmail = "janedoe@example.com";

        reviewer.setReviewerID(newReviewerID);
        reviewer.setName(newName);
        reviewer.setEmail(newEmail);

        assertAll(
                () -> assertEquals(newReviewerID, reviewer.getReviewerID(), "setReviewerID should set the correct ID"),
                () -> assertEquals(newName, reviewer.getName(), "setName should set the correct name"),
                () -> assertEquals(newEmail, reviewer.getEmail(), "setEmail should set the correct email")
        );
    }

    @Test
    void testReviewDataPrintsCorrectMessage() {
        reviewer.reviewData();
        assertEquals("Reviewing data...\r\n", outputStreamCaptor.toString(),
                "reviewData should print the correct message");
    }

    @Test
    void testEditDataPrintsCorrectMessage() {
        reviewer.editData();
        assertEquals("Editing data...\r\n", outputStreamCaptor.toString(),
                "editData should print the correct message");
    }
}
