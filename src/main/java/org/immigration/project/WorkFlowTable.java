package org.immigration.project;

import java.util.ArrayList;

public class WorkFlowTable {
    ArrayList<WorkFlowItem> table;
    int numItems;

    public WorkFlowTable() {
        table = new ArrayList<>();
        numItems = 0;
    }

    public void addWorkflowItem(WorkFlowItem item) {
        table.add(item);
        numItems++;
    }

    public int getNumItems() {
        return numItems;
    }

    public WorkFlowItem getNextItem() {
        return table.remove(0);
    }

    public void updateWorkflowItem(WorkFlowItem item) {
        for (int i = 0; i < table.size(); i++) {
            if (table.get(i).getItemId().equals(item.getItemId())) {
                table.set(i, item);
                return;
            }
        }
        System.out.println("Item not found in the table.");
    }
}

