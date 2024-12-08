package com.example.internmaster.Application;

import com.example.internmaster.Offer.OfferModel;
import com.example.internmaster.Status;
import com.example.internmaster.Student.StudentModel;
import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.Arrays;
import java.util.Date;
@Entity
@Table(name = "application")
public class ApplicationModel {
    @Id
    @SequenceGenerator(
            initialValue = 1,
            name = "application_id",
            sequenceName = "application_id",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "application_id"
    )
    private long id;
    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    private Date applicationDate;
    @Enumerated(EnumType.STRING)
    private Status status;
    @Lob
    private byte[] cv;
    @Lob
    private byte[] applicationLetter;
    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "student_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private StudentModel student;
    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "offer_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private OfferModel offer;

    public StudentModel getStudent() {
        return student;
    }

    public ApplicationModel() {
    }

    public void setStudent(StudentModel student) {
        this.student = student;
    }

    public OfferModel getOffer() {
        return offer;
    }

    public void setOffer(OfferModel offer) {
        this.offer = offer;
    }


    public ApplicationModel(Date applicationDate, Status status, byte[] cv, byte[] applicationLetter, StudentModel student, OfferModel offer) {
        this.applicationDate = applicationDate;
        this.status = status;
        this.cv = cv;
        this.applicationLetter = applicationLetter;
        this.student = student;
        this.offer = offer;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getApplicationDate() {
        return applicationDate;
    }

    public void setApplicationDate(Date applicationDate) {
        this.applicationDate = applicationDate;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public byte[] getCv() {
        return cv;
    }

    public void setCv(byte[] cv) {
        this.cv = cv;
    }

    public byte[] getApplicationLetter() {
        return applicationLetter;
    }

    public void setApplicationLetter(byte[] applicationLetter) {
        this.applicationLetter = applicationLetter;
    }

    @Override
    public String toString() {
        return "ApplicationModel{" +
                "id=" + id +
                ", applicationDate=" + applicationDate +
                ", status=" + status +
                ", cv=" + Arrays.toString(cv) +
                ", applicationLetter=" + Arrays.toString(applicationLetter) +
                ", student=" + student.getId() +
                ", offer=" + offer.getId() +
                '}';
    }
}
