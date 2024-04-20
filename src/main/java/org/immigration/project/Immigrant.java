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

    public Immigrant(String name, String email, String country, Status status, String address, LocalDate date) {
        this.name = name;
        this.email = email;
        this.country = country;
        this.status = status;
        this.address = address;
        this.date = date;
        this.immigrantId = UUID.randomUUID();
        this.documents = new ArrayList<>();
        this.dependents = new ArrayList<>();
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

    public void setEmailNotification(EmailNotification emailNotification) {
        this.emailNotification = emailNotification;
    }

    public EmailNotification getEmailNotification() {
        return emailNotification;
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
}
