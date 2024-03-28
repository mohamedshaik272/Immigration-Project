package org.immigration.project;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

class StatusTest {

    @Test
    void testStatusEnumHasCorrectDisplayName() {
        assertEquals("New", Status.NEW.getDisplayName(), "Display name for NEW should be 'New'");
        assertEquals("In Review", Status.IN_REVIEW.getDisplayName(), "Display name for IN_REVIEW " +
                "should be 'In Review'");
        assertEquals("Approved", Status.APPROVED.getDisplayName(), "Display name for APPROVED " +
                "should be 'Approved'");
        assertEquals("Rejected", Status.REJECTED.getDisplayName(), "Display name for REJECTED " +
                "should be 'Rejected'");
        assertEquals("On Hold", Status.ON_HOLD.getDisplayName(), "Display name for ON_HOLD should" +
                " be 'On Hold'");
        assertEquals("Closed", Status.CLOSED.getDisplayName(), "Display name for CLOSED should be" +
                " 'Closed'");
    }

    @Test
    void testStatusEnumValues() {
        // Check that all enum values are present
        Status[] statuses = Status.values();
        assertEquals(6, statuses.length, "There should be 6 statuses defined");

        assertTrue(containsStatus(statuses, Status.NEW), "Status enum should contain NEW");
        assertTrue(containsStatus(statuses, Status.IN_REVIEW), "Status enum should contain " +
                "IN_REVIEW");
        assertTrue(containsStatus(statuses, Status.APPROVED), "Status enum should contain " +
                "APPROVED");
        assertTrue(containsStatus(statuses, Status.REJECTED), "Status enum should contain " +
                "REJECTED");
        assertTrue(containsStatus(statuses, Status.ON_HOLD), "Status enum should contain ON_HOLD");
        assertTrue(containsStatus(statuses, Status.CLOSED), "Status enum should contain CLOSED");
    }

    private boolean containsStatus(Status[] statuses, Status status) {
        for (Status s : statuses) {
            if (s == status) {
                return true;
            }
        }
        return false;
    }
}
