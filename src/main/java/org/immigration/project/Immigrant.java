package org.immigration.project;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Immigrant {
    private String name;
    private String email;
    private String country;
    private Status status;
    private final UUID immigrantId;
    private WorkFlowItem workFlowItem;
    private String address;
    private EmailNotification emailNotification;
    private Approver approver;
    private Reviewer reviewer;
    private List<String> documents;
    private List<Dependent> dependents;
    private LocalDate date;

    // Builder constructor is private to enforce use of the Builder.
    private Immigrant(Builder builder) {
        this.name = builder.name;
        this.email = builder.email;
        this.country = builder.country;
        this.status = builder.status;
        this.address = builder.address;
        this.documents = new ArrayList<>(builder.documents);
        this.dependents = new ArrayList<>(builder.dependents);
        this.date = builder.date;
        this.immigrantId = UUID.randomUUID();
        this.emailNotification = new EmailNotification();
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getCountry() {
        return country;
    }

    public Status getStatus() {
        return status;
    }

    public void setEmailNotification(EmailNotification emailNotification) {
        this.emailNotification = emailNotification;
    }

    public EmailNotification getEmailNotification() {
        return emailNotification;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public UUID getImmigrantId() {
        return immigrantId;
    }

    public WorkFlowItem getWorkFlowItem() {
        return workFlowItem;
    }

    public String getAddress() {
        return address;
    }

    public Approver getApprover() {
        return approver;
    }

    public Reviewer getReviewer() {
        return reviewer;
    }

    public List<String> getDocuments() {
        return new ArrayList<>(documents); // Return a copy to prevent external modifications.
    }

    public List<Dependent> getDependents() {
        return new ArrayList<>(dependents); // Return a copy to prevent external modifications.
    }

    public LocalDate getDate() {
        return date;
    }

    // Functional methods.

    public void submitDocuments() {
        workFlowItem = new WorkFlowItem(name, status, reviewer);
        emailNotification.sendEmail("Documents Submitted", "Documents submitted by " + name);
    }

    public void submitApplication() {
        workFlowItem = new WorkFlowItem(name, status, reviewer);
        emailNotification.sendEmail("Application Submitted", "Application submitted by " + name);
    }

    public void addDependent(Dependent dependent) {
        // Using List.contains to check if the dependent is already in the list
        if (!dependents.contains(dependent)) {
            dependents.add(dependent);
        }
    }

    // Static nested Builder class.
    public static class Builder {
        private String name;
        private String email;
        private String country;
        private Status status;
        private String address;
        private List<String> documents = new ArrayList<>();
        private List<Dependent> dependents = new ArrayList<>();
        private LocalDate date;

        public Builder withName(String name) {
            this.name = name;
            return this;
        }

        // Additional builder methods for setting other properties...

        public Immigrant build() {
            return new Immigrant(this);
        }
    }
}

