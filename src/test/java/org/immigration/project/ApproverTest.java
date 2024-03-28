package org.immigration.project;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

class ApproverTest {

    private WorkFlowTable mockWorkFlowTable;
    private EmailNotification mockEmailNotification;
    private Approver approver;
    private WorkFlowItem mockWorkFlowItem;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @BeforeEach
    void setUp() {
        // Set up the mocks
        mockWorkFlowTable = Mockito.mock(WorkFlowTable.class);
        mockEmailNotification = Mockito.mock(EmailNotification.class);
        mockWorkFlowItem = Mockito.mock(WorkFlowItem.class);

        // Capture System.out for verification
        System.setOut(new PrintStream(outContent));

        // Initialize Approver with mocks
        approver = new Approver(mockWorkFlowTable, mockEmailNotification);
    }

    @Test
    void testLoadApprovalItemWithAvailableItem() {
        // Set up behavior for the mock
        when(mockWorkFlowTable.getNextItem()).thenReturn(mockWorkFlowItem);
        when(mockWorkFlowItem.getItemId());

        // Call the method to test
        approver.loadApprovalItem();

        // Verify the output and interactions
        assertEquals("Loaded item for approval: Item1\r\n", outContent.toString());
        verify(mockWorkFlowTable).getNextItem();
    }

    @Test
    void testLoadApprovalItemWithNoAvailableItem() {
        // Set up behavior for the mock to return null
        when(mockWorkFlowTable.getNextItem()).thenReturn(null);

        // Call the method to test
        approver.loadApprovalItem();

        // Verify the output and interactions
        assertEquals("No items available for approval.\r\n", outContent.toString());
        verify(mockWorkFlowTable).getNextItem();
    }

    @Test
    void testApproveItemWithNoItemLoaded() {
        // Method call
        boolean result = approver.approveItem();

        // Verify output and result
        assertFalse(result);
        assertEquals("No item loaded for approval.\r\n", outContent.toString());
    }

    @Test
    void testApproveItemWithItemLoaded() {
        // Prepare the mock
        when(mockWorkFlowTable.getNextItem()).thenReturn(mockWorkFlowItem);
        when(mockWorkFlowItem.getItemId());

        // Load item for approval
        approver.loadApprovalItem();

        // Approve the item
        boolean result = approver.approveItem();

        // Verify
        assertTrue(result);
        assertEquals("Loaded item for approval: Item1\r\nItem approved: Item1\r\n", outContent.toString());
        verify(mockWorkFlowItem).setStatus(Status.APPROVED);
        verify(mockWorkFlowTable).updateWorkflowItem(mockWorkFlowItem);
    }

    @Test
    void testReturnToReviewerWithNoItemLoaded() {
        // Method call
        boolean result = approver.returnToReviewer();

        // Verify output and result
        assertFalse(result);
        assertEquals("No item loaded to return.\r\n", outContent.toString());
    }

    @Test
    void testReturnToReviewerWithItemLoaded() {
        // Prepare the mock
        when(mockWorkFlowTable.getNextItem()).thenReturn(mockWorkFlowItem);
        when(mockWorkFlowItem.getItemId());

        // Load item for returning
        approver.loadApprovalItem();

        // Return the item to reviewer
        boolean result = approver.returnToReviewer();

        // Verify
        assertTrue(result);
        assertEquals("Loaded item for approval: Item1\r\nItem returned to reviewer: Item1\r\n", outContent.toString());
        verify(mockWorkFlowItem).setStatus(Status.IN_REVIEW);
        verify(mockWorkFlowTable).updateWorkflowItem(mockWorkFlowItem);
    }
}
