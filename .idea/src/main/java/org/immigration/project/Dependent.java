package org.immigration.project;

import java.time.LocalDate;

public class Dependent {
    private String name;
    private String relationship;
    private LocalDate dateOfBirth;

    private Dependent(Builder builder) {
        this.name = builder.name;
        this.relationship = builder.relationship;
        this.dateOfBirth = builder.dateOfBirth;
    }

    public String getName() {
        return name;
    }

    public String getRelationship() {
        return relationship;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
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
            if (dateOfBirth == null) {
                throw new IllegalArgumentException("Date of birth cannot be null");
            }
            this.dateOfBirth = dateOfBirth;
            return this;
        }

        public Dependent build() {
            return new Dependent(this);
        }
    }
}

