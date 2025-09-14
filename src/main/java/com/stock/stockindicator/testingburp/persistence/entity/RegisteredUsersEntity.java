package com.stock.stockindicator.testingburp.persistence.entity;
import jakarta.persistence.*;

@Entity
@Table(name = "Students")
public class RegisteredUsersEntity {

    @Id
    @Column(length = 50)
    private String id;  // manually provided primary key

    @Column(length = 100, nullable = false)
    private String name;

    @Column(length = 20)
    private String phone;

    @Column(length = 100)
    private String email;

    @Column(length = 50)
    private String roll;

    @Column(length = 200)
    private String instituteName;

    @Column(length = 20)
    private String aadhar;

    @Column(length = 10)
    private String validationStatus;

    @Column(length = 10)
    private String courseDuration;

    @Column(length = 300)
    private String address;

    @Column(length = 100)
    private String branchName;

    @Column(length = 300)
    private String instituteAddress;

    @Column(length = 200)
    private String courseName;

    @Column(length = 20)
    private String coappContact;

    @Column(length = 20)
    private String instituteContact;

    @Column(length = 100)
    private String coApplicantName;

    @Column(length = 300)
    private String coApplicantAddress;

    // Getters and Setters

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRoll() {
        return roll;
    }

    public void setRoll(String roll) {
        this.roll = roll;
    }

    public String getInstituteName() {
        return instituteName;
    }

    public void setInstituteName(String instituteName) {
        this.instituteName = instituteName;
    }

    public String getAadhar() {
        return aadhar;
    }

    public void setAadhar(String aadhar) {
        this.aadhar = aadhar;
    }

    public String getValidationStatus() {
        return validationStatus;
    }

    public void setValidationStatus(String validationStatus) {
        this.validationStatus = validationStatus;
    }

    public String getCourseDuration() {
        return courseDuration;
    }

    public void setCourseDuration(String courseDuration) {
        this.courseDuration = courseDuration;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    public String getInstituteAddress() {
        return instituteAddress;
    }

    public void setInstituteAddress(String instituteAddress) {
        this.instituteAddress = instituteAddress;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCoappContact() {
        return coappContact;
    }

    public void setCoappContact(String coappContact) {
        this.coappContact = coappContact;
    }

    public String getInstituteContact() {
        return instituteContact;
    }

    public void setInstituteContact(String instituteContact) {
        this.instituteContact = instituteContact;
    }

    public String getCoApplicantName() {
        return coApplicantName;
    }

    public void setCoApplicantName(String coApplicantName) {
        this.coApplicantName = coApplicantName;
    }

    public String getCoApplicantAddress() {
        return coApplicantAddress;
    }

    public void setCoApplicantAddress(String coApplicantAddress) {
        this.coApplicantAddress = coApplicantAddress;
    }
}
