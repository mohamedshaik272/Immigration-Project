package org.immigration.project;

import java.time.LocalDate;

public class Dependent {
    private String name;
    private String relationship;
    private LocalDate dateOfBirth;

    // Private constructor to enforce the use of the builder
    private Dependent() {
    }

    // Getter methods
    public String getName() {
        return name;
    }

    public String getRelationship() {
        return relationship;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    // Setter methods (if needed)
    public void setName(String name) {
        this.name = name;
    }

    public void setRelationship(String relationship) {
        this.relationship = relationship;
    }

    public void setDateOfBirth(LocalDate dob) {
        this.dateOfBirth = dob;
    }

    // Override toString to provide a meaningful representation
    @Override
    public String toString() {
        return "Name: " + name +
                ", Relationship: " + relationship;
    }

    // Builder Class
    public static class Builder {
        private String name;
        private String relationship;
        private LocalDate dateOfBirth;

        public Builder withName(String name) {
            if (name == null || name.trim().isEmpty()) {
                throw new IllegalArgumentException("Name cannot be null or empty");
            }
            this.name = name;
            return this;
        }

        public Builder withRelationship(String relationship) {
            if (relationship == null || relationship.trim().isEmpty()) {
                throw new IllegalArgumentException("Relationship cannot be null or empty");
            }
            this.relationship = relationship;
            return this;
        }

        public Builder withDateOfBirth(LocalDate dateOfBirth) {
            this.dateOfBirth = dateOfBirth;
            return this;
        }

        public Dependent build() {
            Dependent dependent = new Dependent();
            dependent.name = this.name;
            dependent.relationship = this.relationship;
            dependent.dateOfBirth = this.dateOfBirth;
            return dependent;
        }
    }
}
