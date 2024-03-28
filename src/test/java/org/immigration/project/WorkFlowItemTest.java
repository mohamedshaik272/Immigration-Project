package org.immigration.project;

import org.immigration.project.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

class WorkFlowItemTest {

    private WorkFlowItem workFlowItem;
    private LocalDateTime testTime;
    private Reviewer reviewer;

    @BeforeEach
    void setUp() {
        reviewer = new Reviewer(1, "Reviewer Name", "reviewer@example.com");
        workFlowItem = new WorkFlowItem("WorkFlow Item", Status.NEW, reviewer);
        testTime = LocalDateTime.now();
    }

    @Test
    void testConstructor() {
        assertNotNull(workFlowItem.getItemId(), "Item ID should not be null after construction.");
        assertEquals(Status.NEW, workFlowItem.getStatus(), "Status should be NEW after construction.");
    }

    @Test
    void testAssignedTo() {
        workFlowItem.setAssignedTo("Assigned Person");
        assertEquals("Assigned Person", workFlowItem.getAssignedTo(), "AssignedTo should match the string set by setAssignedTo.");
    }

    @Test
    void testDescription() {
        String description = "This is a test description.";
        workFlowItem.setDescription(description);
        assertEquals(description, workFlowItem.getDescription(), "Description should match the string set by setDescription.");
    }

    @Test
    void testDeadline() {
        workFlowItem.setDeadline(testTime);
        assertEquals(testTime, workFlowItem.getDeadline(), "Deadline should match the time set by setDeadline.");
    }

    @Test
    void testCompletionDateAndStatus() {
        workFlowItem.setCompletionDate(testTime);
        assertEquals(testTime, workFlowItem.getCompletionDate(), "CompletionDate should match the time set by setCompletionDate.");
    }

    @Test
    void testStatus() {
        workFlowItem.setStatus(Status.APPROVED);
        assertEquals(Status.APPROVED, workFlowItem.getStatus(), "Status should match the status set by setStatus.");
    }
}
