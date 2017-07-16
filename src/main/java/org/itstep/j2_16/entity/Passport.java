package org.itstep.j2_16.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import static java.util.Arrays.asList;
import static org.apache.commons.lang3.StringUtils.join;

@Entity(name = "PASSPORT")
public class Passport {
    @Id
    private String id;
    private String passportSeries;
    private String passportNumber;

    @OneToOne(mappedBy = "passport")
    private Student student;
    public Student getStudent() {
        return student;
    }
    public void setStudent(Student student) {
        this.student = student;
    }

    public Passport() {
    }

    public Passport(String passportSeries, String passportNumber) {
        setPassportSeries(passportSeries);
        setPassportNumber(passportNumber);
        setId();
    }

    public String getId() {
        return id;
    }

    public void setId() {
        this.id = join(asList(passportSeries, passportNumber), " ");
    }

    public String getPassportSeries() {
        return passportSeries;
    }

    public void setPassportSeries(String passportSeries) {
        this.passportSeries = passportSeries;
        setId();

    }

    public String getPassportNumber() {
        return passportNumber;
    }

    public void setPassportNumber(String passportNumber) {
        this.passportNumber = passportNumber;
        setId();
    }
}
