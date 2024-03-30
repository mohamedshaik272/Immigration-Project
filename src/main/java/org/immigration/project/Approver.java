package org.immigration.project;

public class Approver {
    WorkFlowTable wft;
    WorkFlowItem approvalItem;
    EmailNotification emailNotification;

    // Constructor
    public Approver(WorkFlowTable wft, EmailNotification emailNotification) {
        this.wft = wft;
        this.approvalItem = null;
        this.emailNotification = emailNotification;
    }

    // Methods
    public void loadApprovalItem() {
        approvalItem = wft.getNextItem();
        if (approvalItem != null) {
            System.out.println("Loaded item for approval: " + approvalItem.getItemId());
        } else {
            System.out.println("No items available for approval.");
        }
    }

    // Approve the item
    public boolean approveItem() {
        if (approvalItem == null) {
            System.out.println("No item loaded for approval.");
            return false;
        }
        // Update the status of the item to approved
        updateWorkflowStatus(approvalItem, Status.APPROVED);
        System.out.println("Item approved: " + approvalItem.getItemId());
        return true;
    }
    // Reject the item
    public boolean returnToReviewer() {
        if (approvalItem == null) {
            System.out.println("No item loaded to return.");
            return false;
        }
        // Update the status of the item to in review
        updateWorkflowStatus(approvalItem, Status.IN_REVIEW);
        //emailNotification.sendEmail(); //to reviewer
        System.out.println("Item returned to reviewer: " + approvalItem.getItemId());
        return true;
    }
    // update the workflow status
    private void updateWorkflowStatus(WorkFlowItem item, Status newStatus) {
        item.setStatus(newStatus);
        wft.updateWorkflowItem(item);
    }
}