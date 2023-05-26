package org.example;

public class User {

    private String dateOfBirth;
    private String fullName;

    public User(String dateOfBirth, String name) {

        this.dateOfBirth = dateOfBirth;
        this.fullName = name;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getName() {
        return fullName;
    }

    public void setName(String name) {
        this.fullName = name;
    }

}
