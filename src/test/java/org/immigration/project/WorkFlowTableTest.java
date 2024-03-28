package org.immigration.project;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.NoSuchElementException;

class WorkFlowTableTest {

    private WorkFlowTable workFlowTable;
    private WorkFlowItem workFlowItem1;
    private WorkFlowItem workFlowItem2;

    @BeforeEach
    void setUp() {
        workFlowTable = new WorkFlowTable();
        workFlowItem1 = new WorkFlowItem("Item1", Status.NEW, null);
        workFlowItem2 = new WorkFlowItem("Item2", Status.NEW, null);
    }

    @Test
    void testAddWorkflowItem() {
        workFlowTable.addWorkflowItem(workFlowItem1);
        assertEquals(1, workFlowTable.getNumItems(), "The number of items should be 1 after adding an item.");

        workFlowTable.addWorkflowItem(workFlowItem2);
        assertEquals(2, workFlowTable.getNumItems(), "The number of items should be 2 after adding another item.");
    }

    @Test
    void testGetNextItem() {
        workFlowTable.addWorkflowItem(workFlowItem1);
        WorkFlowItem retrievedItem = workFlowTable.getNextItem();
        assertSame(workFlowItem1, retrievedItem, "The retrieved item should be the same as the one added.");

        assertEquals(0, workFlowTable.getNumItems(), "The number of items should decrease after retrieval.");
    }

    @Test
    void testGetNextItemWhenEmpty() {
        assertThrows(NoSuchElementException.class, () -> {
            workFlowTable.getNextItem();
        }, "Getting the next item from an empty table should throw a NoSuchElementException.");
    }

    @Test
    void testUpdateWorkflowItem() {
        workFlowTable.addWorkflowItem(workFlowItem1);
        workFlowItem1.setStatus(Status.APPROVED);

        workFlowTable.updateWorkflowItem(workFlowItem1);

        WorkFlowItem updatedItem = workFlowTable.getNextItem();
        assertSame(Status.APPROVED, updatedItem.getStatus(), "The status of the item should be updated to APPROVED.");
    }

    @Test
    void testUpdateWorkflowItemNotInTable() {
        workFlowTable.addWorkflowItem(workFlowItem1);
        // Attempting to update an item not in the table
        workFlowTable.updateWorkflowItem(workFlowItem2);

        assertEquals(1, workFlowTable.getNumItems(), "The number of items should not change after trying to update a non-existing item.");
    }
}
