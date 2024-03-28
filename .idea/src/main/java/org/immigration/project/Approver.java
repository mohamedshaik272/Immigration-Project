package org.immigration.project;

public class Approver {
    WorkFlowTable wft;
    WorkFlowItem approvalItem;
    EmailNotification emailNotification;

    public Approver(WorkFlowTable wft, EmailNotification emailNotification) {
        this.wft = wft;
        this.approvalItem = null;
        this.emailNotification = emailNotification;
    }

    public void loadApprovalItem() {
        approvalItem = wft.getNextItem();
        if (approvalItem != null) {
            System.out.println("Loaded item for approval: " + approvalItem.getItemId());
        } else {
            System.out.println("No items available for approval.");
        }
    }

    public boolean approveItem() {
        if (approvalItem == null) {
            System.out.println("No item loaded for approval.");
            return false;
        }

        updateWorkflowStatus(approvalItem, Status.APPROVED);
        System.out.println("Item approved: " + approvalItem.getItemId());
        return true;
    }

    public boolean returnToReviewer() {
        if (approvalItem == null) {
            System.out.println("No item loaded to return.");
            return false;
        }

        updateWorkflowStatus(approvalItem, Status.IN_REVIEW);
        //emailNotification.sendEmail(); //to reviewer
        System.out.println("Item returned to reviewer: " + approvalItem.getItemId());
        return true;
    }

    private void updateWorkflowStatus(WorkFlowItem item, Status newStatus) {
        item.setStatus(newStatus);
        wft.updateWorkflowItem(item);
    }
}