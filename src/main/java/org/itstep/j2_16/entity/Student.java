package org.itstep.j2_16.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "STUDENT")
public class Student {
    @Id
    @GeneratedValue
    private int id;
    private String firstName;
    private String lastName;
    private String fullName;
    private String passport;
    private String description;

    public Student(String firstName, String lastName) {
        setFirstName(firstName);
        setLastName(lastName);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
        setDescription();
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
        setDescription();
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPassport() {
        return passport;
    }

    public void setPassport(String passport) {
        this.passport = passport;
    }

    public String getDescription() {
        return description;
    }

    private void setDescription() {
        description = (firstName == null || firstName.trim().isEmpty() ? "" : firstName + " ")
                + (lastName == null || lastName.trim().isEmpty() ? "" : lastName);
//        description = (StringUtils.isBlank(firstName) ? "" : firstName + " ")
//                + (StringUtils.isBlank(lastName) ? "" : lastName);
    }
}
