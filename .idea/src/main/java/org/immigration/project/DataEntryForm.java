package org.immigration.project;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class DataEntryForm {
    private final UUID formId;
    private Map<String, String> fields;
    private LocalDateTime creationDate;
    private LocalDateTime lastUpdateDate;

    public DataEntryForm() {
        this.formId = UUID.randomUUID();
        this.fields = new HashMap<>();
        this.creationDate = LocalDateTime.now();
        this.lastUpdateDate = this.creationDate;
    }

    // Getters and setters
    public UUID getFormId() {
        return formId;
    }

    public Map<String, String> getFields() {
        return fields;
    }

    public void setField(String fieldName, String value) {
        fields.put(fieldName, value);
        this.lastUpdateDate = LocalDateTime.now();
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public LocalDateTime getLastUpdateDate() {
        return lastUpdateDate;
    }
}

