package com.example.internmaster.Offer;

import com.example.internmaster.Company.CompanyModel;
import com.example.internmaster.Type;
import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.Date;

@Entity
@Table(name = "offer")
public class OfferModel {
    @Id
    @SequenceGenerator(
            initialValue = 1,
            name = "offer_id",
            sequenceName = "offer_id",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "offer_id"
    )
    private long id;
    @Column(length = 200, nullable = false)
    private String title;
    @Column(columnDefinition = "TEXT")
    private String description;

    @Enumerated(EnumType.STRING) // Map Enum to String in the DB
    private Type type;
    @Column(length = 200, nullable = false)
    private String domaine;
    @Column(length = 200, nullable = false)
    private String duration;
    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    private Date startDate;
    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    private Date endDate;
    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    private Date postDate;
    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "company_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private CompanyModel company;

    public OfferModel(String title, String description, Type type, String domaine, String duration, Date startDate, Date endDate, Date postDate, CompanyModel company) {
        this.title = title;
        this.description = description;
        this.type = type;
        this.domaine = domaine;
        this.duration = duration;
        this.startDate = startDate;
        this.endDate = endDate;
        this.postDate = postDate;
        this.company = company;
    }
    public OfferModel(){}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public String getDomaine() {
        return domaine;
    }

    public void setDomaine(String domaine) {
        this.domaine = domaine;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Date getPostDate() {
        return postDate;
    }

    public void setPostDate(Date postDate) {
        this.postDate = postDate;
    }

    public CompanyModel getCompany() {
        return company;
    }

    public void setCompany(CompanyModel company) {
        this.company = company;
    }

    @Override
    public String toString() {
        return "OfferModel{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", type=" + type +
                ", domaine='" + domaine + '\'' +
                ", duration='" + duration + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", postDate=" + postDate +
                ", company=" + company.getId() +
                '}';
    }
}
