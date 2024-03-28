package org.immigration.project;

import java.time.LocalDateTime;
import java.util.UUID;

public class WorkFlowItem {
    private final UUID itemId;
    private String assignedTo;
    private String description;
    private LocalDateTime deadline;
    private LocalDateTime completionDate;
    private Status status;

    // Constructor initializes the item with a unique ID.
    public WorkFlowItem(String name, Status status, Reviewer reviewer) {
        this.itemId = UUID.randomUUID();
        this.status = Status.NEW; // default status
    }

    // Getters and setters
    public UUID getItemId() {
        return itemId;
    }

    public String getAssignedTo() {
        return assignedTo;
    }

    public void setAssignedTo(String assignedTo) {
        this.assignedTo = assignedTo;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getDeadline() {
        return deadline;
    }

    public void setDeadline(LocalDateTime deadline) {
        this.deadline = deadline;
    }

    public LocalDateTime getCompletionDate() {
        return completionDate;
    }

    public void setCompletionDate(LocalDateTime completionDate) {
        this.completionDate = completionDate;
        if (completionDate != null) {
            //this.status = Status.COMPLETED;
        }
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
