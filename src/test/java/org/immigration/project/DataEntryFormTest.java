package org.immigration.project;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDateTime;
import java.util.Map;

class DataEntryFormTest {

    private DataEntryForm dataEntryForm;

    @BeforeEach
    void setUp() {
        dataEntryForm = new DataEntryForm();
    }

    @Test
    void testFormIdIsGenerated() {
        assertNotNull(dataEntryForm.getFormId(), "Form ID should be generated and not null");
    }

    @Test
    void testFormFieldsAreEmptyOnCreation() {
        assertTrue(dataEntryForm.getFields().isEmpty(), "Fields should be empty on creation");
    }

    @Test
    void testCreationDateIsSet() {
        assertNotNull(dataEntryForm.getCreationDate(), "Creation date should be set on creation");
    }

    @Test
    void testLastUpdateDateIsSameAsCreationDateOnCreation() {
        assertEquals(dataEntryForm.getCreationDate(), dataEntryForm.getLastUpdateDate(),
                "Last update date should be the same as creation date on creation");
    }

    @Test
    void testSetFieldUpdatesTheFieldValue() {
        String fieldName = "testField";
        String value = "testValue";
        dataEntryForm.setField(fieldName, value);

        Map<String, String> fields = dataEntryForm.getFields();
        assertTrue(fields.containsKey(fieldName), "Fields should contain the key set by setField");
        assertEquals(value, fields.get(fieldName), "Field value should match the value set by " +
                "setField");
    }

    @Test
    void testSetFieldUpdatesLastUpdateDate() {
        LocalDateTime beforeUpdate = dataEntryForm.getLastUpdateDate();
        try {
            Thread.sleep(1000); // Sleep to ensure the time will be different
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        dataEntryForm.setField("testField", "testValue");

        LocalDateTime afterUpdate = dataEntryForm.getLastUpdateDate();
        assertNotEquals(beforeUpdate, afterUpdate, "Last update date should be updated after " +
                "calling setField");
    }
}
