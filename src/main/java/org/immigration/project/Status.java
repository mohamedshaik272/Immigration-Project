package org.immigration.project;

public enum Status {
    NEW("New"),
    IN_REVIEW("In Review"),
    APPROVED("Approved"),
    REJECTED("Rejected"),
    ON_HOLD("On Hold"),
    CLOSED("Closed");

    private final String displayName;

    Status(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}

