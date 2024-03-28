package org.immigration.project;

import org.immigration.project.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

class DependentTest {

    @Test
    void testBuilderWithValidData() {
        String name = "John Doe";
        String relationship = "Son";
        LocalDate dob = LocalDate.of(2010, 1, 1);

        Dependent dependent = new Dependent.Builder()
                .withName(name)
                .withRelationship(relationship)
                .withDateOfBirth(dob)
                .build();

        assertNotNull(dependent, "Dependent object should not be null");
        assertEquals(name, dependent.getName(), "Names should match");
        assertEquals(relationship, dependent.getRelationship(), "Relationships should match");
        assertEquals(dob, dependent.getDateOfBirth(), "Dates of birth should match");
    }

    @Test
    void testBuilderWithNullName() {
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                new Dependent.Builder()
                        .withName(null)
                        .withRelationship("Son")
                        .withDateOfBirth(LocalDate.of(2010, 1, 1))
                        .build()
        );

        String expectedMessage = "Name cannot be null or empty";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage), "Exception message should contain the" +
                " correct information");
    }

    @Test
    void testBuilderWithEmptyName() {
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                new Dependent.Builder()
                        .withName("  ")
                        .withRelationship("Son")
                        .withDateOfBirth(LocalDate.of(2010, 1, 1))
                        .build()
        );

        String expectedMessage = "Name cannot be null or empty";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage), "Exception message should contain the" +
                " correct information");
    }

    @Test
    void testBuilderWithNullRelationship() {
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                new Dependent.Builder()
                        .withName("John Doe")
                        .withRelationship(null)
                        .withDateOfBirth(LocalDate.of(2010, 1, 1))
                        .build()
        );

        String expectedMessage = "Relationship cannot be null or empty";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage), "Exception message should contain the" +
                " correct information");
    }

    @Test
    void testBuilderWithNullDateOfBirth() {
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                new Dependent.Builder()
                        .withName("John Doe")
                        .withRelationship("Son")
                        .withDateOfBirth(null)
                        .build()
        );

        String expectedMessage = "Date of birth cannot be null";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage), "Exception message should contain the" +
                " correct information");
    }
}
