package org.immigration.project;

public class Reviewer {
    private int reviewerID;
    private String name;
    private String email;

    // Constructors
    public Reviewer(int reviewerID, String name, String email) {
        this.reviewerID = reviewerID;
        this.name = name;
        this.email = email;
    }

    // Getters and setters
    public int getReviewerID() {
        return reviewerID;
    }

    public void setReviewerID(int reviewerID) {
        this.reviewerID = reviewerID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // Methods
    public void reviewData() {
        System.out.println("Reviewing data...");
    }

    public void editData() {
        System.out.println("Editing data...");
    }
}

