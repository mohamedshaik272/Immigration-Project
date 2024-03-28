package org.immigration.project;

import java.util.ArrayList;
import java.util.NoSuchElementException;

public class WorkFlowTable {
    private final ArrayList<WorkFlowItem> table;

    public WorkFlowTable() {
        table = new ArrayList<>();
    }

    public void addWorkflowItem(WorkFlowItem item) {
        table.add(item);
    }

    public int getNumItems() {
        return table.size();
    }

    public WorkFlowItem getNextItem() {
        if (table.isEmpty()) {
            throw new NoSuchElementException("No more items in the workflow.");
        }
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
