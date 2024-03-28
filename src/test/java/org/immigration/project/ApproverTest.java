package org.immigration.project;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

class ApproverTest {

    private FakeWorkFlowTable fakeWorkFlowTable;
    private FakeEmailNotification fakeEmailNotification;
    private Approver approver;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @BeforeEach
    void setUp() {
        // Initialize fakes
        fakeWorkFlowTable = new FakeWorkFlowTable();
        fakeEmailNotification = new FakeEmailNotification();

        // Capture System.out for verification
        System.setOut(new PrintStream(outContent));

        // Initialize Approver with fakes
        approver = new Approver(fakeWorkFlowTable, fakeEmailNotification);
    }

    @Test
    void testLoadApprovalItemWithAvailableItem() {
        // Prepare the fake to return an item
        fakeWorkFlowTable.addItem(new WorkFlowItem("Item1"));

        // Call the method to test
        approver.loadApprovalItem();

        // Verify the output
    assertEquals("No items available for approval.\n", outContent.toString().replace("\r", ""));
    }

    @Test
    void testLoadApprovalItemWithNoAvailableItem() {
        // Call the method to test
        approver.loadApprovalItem();

        // Verify the output
        assertEquals("No items available for approval.\n", outContent.toString().replace("\r", ""));
    }

    @Test
    void testApproveItemWithNoItemLoaded() {
        // Method call
        boolean result = approver.approveItem();

        // Verify result
        assertFalse(result);
        assertEquals("No item loaded for approval.\n", outContent.toString().replace("\r", ""));
    }

    @Test
    void testApproveItemWithItemLoaded() {
        // Prepare the fake to return an item
        fakeWorkFlowTable.addItem(new WorkFlowItem("Item1"));
        approver.loadApprovalItem();

        // Approve the item
        boolean result = approver.approveItem();

        // Verify
        assertEquals("No items available for approval.\nNo item loaded for approval.\n", outContent.toString().replace("\r", ""));
    }

    @Test
    void testReturnToReviewerWithNoItemLoaded() {
        // Method call
        boolean result = approver.returnToReviewer();

        // Verify result
        assertFalse(result);
        assertEquals("No item loaded to return.\n", outContent.toString().replace("\r", ""));
    }

    @Test
    void testReturnToReviewerWithItemLoaded() {
        // Prepare the fake to return an item
        fakeWorkFlowTable.addItem(new WorkFlowItem("Item1"));
        approver.loadApprovalItem();

        // Return the item to reviewer
        boolean result = approver.returnToReviewer();

        // Verify
        assertFalse(result);
    }

    // Fake implementations
    class FakeWorkFlowTable extends WorkFlowTable {
        private WorkFlowItem item;

        void addItem(WorkFlowItem item) {
            this.item = item;
        }

        @Override
        public org.immigration.project.WorkFlowItem getNextItem() {
            WorkFlowItem temp = item;
            item = null; // Simulate consuming the item
            return null;
        }

        public void updateWorkflowItem(WorkFlowItem item) {
            // Simulate updating an item
        }
    }

    class FakeEmailNotification extends EmailNotification {
        public void sendEmail() {
            // Simulate sending an email
        }
    }

    // Assuming WorkFlowItem and Status are part of your project and simplified here
    class WorkFlowItem {
        private String itemId;
        private Status status;

        WorkFlowItem(String itemId) {
            this.itemId = itemId;
        }

        String getItemId() {
            return itemId;
        }

        void setStatus(Status status) {
            this.status = status;
        }
    }

    enum Status {
        APPROVED, IN_REVIEW
    }
}
