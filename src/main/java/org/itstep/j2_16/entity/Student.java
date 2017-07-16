package org.itstep.j2_16.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import static javax.persistence.CascadeType.ALL;

@Entity(name = "STUDENT") // name of the entity to make a call from the sql criteria and so on
@Table(name = "STUDENT") // name of the table in the DB
public class Student {
    @Id
    @GeneratedValue
    private int id;
    @Column(name = "first_name")
    private String firstName;
    private String lastName;
    private String fullName;
    @OneToOne(cascade = ALL)
    @JoinColumn(name = "passport_id")
    private Passport passport;
    private String description;

    // hibernate merge can't work without default constructor
    public Student() {
    }

    public Student(String firstName, String lastName, Passport passport) {
        setFirstName(firstName);
        setLastName(lastName);
        setFullName();

        setPassport(passport);
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
        setFullName();
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
        setFullName();
    }

    @Column(name = "full_name")
    public String getFullName() {
        return "value from getter: " + fullName;
    }

    public void setFullName() {
        this.fullName = (firstName == null || firstName.trim().isEmpty() ? "" : firstName + " ")
                + (lastName == null || lastName.trim().isEmpty() ? "" : lastName);
//        description = (StringUtils.isBlank(firstName) ? "" : firstName + " ")
//                + (StringUtils.isBlank(lastName) ? "" : lastName);
    }

    public Passport getPassport() {
        return passport;
    }

    public void setPassport(Passport passport) {
        this.passport = passport;
    }

    public String getDescription() {
        return description;
    }

    private void setDescription(String description) {
        this.description = description;
    }
}
