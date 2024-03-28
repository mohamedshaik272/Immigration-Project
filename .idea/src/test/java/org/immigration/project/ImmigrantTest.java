package org.immigration.project;

import org.immigration.project.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class ImmigrantTest {

    private Immigrant.Builder immigrantBuilder;
    private EmailNotification mockEmailNotification;

    @BeforeEach
    void setUp() {
        immigrantBuilder = new Immigrant.Builder()
                .withName("John Doe");
        mockEmailNotification = Mockito.mock(EmailNotification.class);
    }

    @Test
    void testBuilderCreatesImmigrant() {
        Immigrant immigrant = immigrantBuilder.build();
        assertNotNull(immigrant, "Builder should create an instance of Immigrant");
        assertEquals("John Doe", immigrant.getName(), "Builder should set the name correctly");
    }

    @Test
    void testGetters() {
        Immigrant immigrant = immigrantBuilder.build();
        assertEquals("John Doe", immigrant.getName());
    }

    @Test
    void testSubmitDocumentsSendsEmail() {
        Immigrant immigrant = immigrantBuilder.build();
        immigrant.emailNotification = mockEmailNotification;

        immigrant.submitDocuments();

        Mockito.verify(mockEmailNotification).sendEmail(
                Mockito.eq("Documents Submitted"),
                Mockito.contains("Documents submitted by John Doe")
        );
    }

    @Test
    void testSubmitApplicationSendsEmail() {
        Immigrant immigrant = immigrantBuilder.build();
        // Inject mock EmailNotification
        immigrant.emailNotification = mockEmailNotification;

        immigrant.submitApplication();

        Mockito.verify(mockEmailNotification).sendEmail(
                Mockito.eq("Application Submitted"),
                Mockito.contains("Application submitted by John Doe")
        );
    }

    @Test
    void testAddDependent() {
        Dependent dependent = new Dependent.Builder()
                .withName("Jane Doe")
                .build();
        Immigrant immigrant = immigrantBuilder.build();

        immigrant.addDependent(dependent);

        assertTrue(immigrant.getDependents().contains(dependent), "Dependent should be added to " +
                "the list");
    }

    @Test
    void testAddDependentIgnoresDuplicates() {
        Dependent dependent = new Dependent.Builder()
                .withName("Jane Doe")
                .build();
        Immigrant immigrant = immigrantBuilder.build();

        immigrant.addDependent(dependent);
        immigrant.addDependent(dependent); // Attempt to add the same dependent again

        assertEquals(1, immigrant.getDependents().size(), "Duplicate dependents should not be " +
                "added");
    }
}
