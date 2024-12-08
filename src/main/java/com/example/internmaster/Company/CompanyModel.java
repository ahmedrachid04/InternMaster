package com.example.internmaster.Company;

import jakarta.persistence.*;

@Entity
@Table(name = "company")
public class CompanyModel {
    @Id
    @SequenceGenerator(
            initialValue = 1,
            name = "company_id",
            sequenceName = "company_id",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "company_id"
    )
    private long id;
    @Column(length = 200, nullable = false)
    private String name;
    @Column(length = 200, nullable = false)
    private String address;
    @Column(length = 200, nullable = false)
    private String contactEmail;
    @Column(length = 200, nullable = false)
    private String contactNumber;
    @Column(length = 200)
    private String fax;
    @Column(columnDefinition = "TEXT")
    private String description;
    @Lob
    private byte[] logo;
    @Column(length = 200, nullable = false)
    private String password;

    public CompanyModel(String name, String addresse, String contactEmail, String contactNumber, String fax, String description, byte[] logo, String password) {
        this.name = name;
        this.address = addresse;
        this.contactEmail = contactEmail;
        this.contactNumber = contactNumber;
        this.fax = fax;
        this.description = description;
        this.logo = logo;
        this.password = password;
    }

    public CompanyModel() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddresse() {
        return address;
    }

    public void setAddresse(String addresse) {
        this.address = addresse;
    }

    public String getContactEmail() {
        return contactEmail;
    }

    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public byte[] getLogo() {
        return logo;
    }

    public void setLogo(byte[] logo) {
        this.logo = logo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Company{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", addresse='" + address + '\'' +
                ", contactEmail='" + contactEmail + '\'' +
                ", contactNumber='" + contactNumber + '\'' +
                ", fax='" + fax + '\'' +
                ", description='" + description + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
