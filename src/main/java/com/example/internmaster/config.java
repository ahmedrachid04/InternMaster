package com.example.internmaster;

import com.example.internmaster.Application.ApplicationModel;
import com.example.internmaster.Application.ApplicationService;
import com.example.internmaster.Company.CompanyModel;
import com.example.internmaster.Company.CompanyService;
import com.example.internmaster.Offer.OfferModel;
import com.example.internmaster.Offer.OfferService;
import com.example.internmaster.Status;
import com.example.internmaster.Student.StudentModel;
import com.example.internmaster.Student.StudentService;
import com.example.internmaster.Type;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Date;
import java.util.Random;

@Configuration
public class config {

    @Bean
    CommandLineRunner populateData(
            StudentService studentService,
            CompanyService companyService,
            OfferService offerService,
            ApplicationService applicationService
    ) {
        return args -> {
            // Populate Students
            for (int i = 1; i <= 10; i++) {
                StudentModel student = new StudentModel(
                        "FirstName" + i,
                        "LastName" + i,
                        "student" + i + "@example.com",
                        "123456789" + i,
                        "Specialty" + i,
                        null,
                        "School" + i,
                        "password" + i
                );
                studentService.addStudent(student);
            }

            // Populate Companies
            for (int i = 1; i <= 10; i++) {
                CompanyModel company = new CompanyModel(
                        "Company" + i,
                        "Address" + i,
                        "contact" + i + "@company.com",
                        "987654321" + i,
                        "123-456-789" + i,
                        "Description for Company " + i,
                        null,
                        "password" + i
                );
                companyService.addCompany(company);
            }

            // Fetch created companies
            var companies = companyService.getCompanies();

            // Populate Offers
            for (int i = 1; i <= 10; i++) {
                OfferModel offer = new OfferModel(
                        "Offer Title " + i,
                        "Description for Offer " + i,
                        Type.values()[new Random().nextInt(Type.values().length)], // Random Type
                        "Domaine" + i,
                        i + " months",
                        new Date(),
                        new Date(System.currentTimeMillis() + (1000L * 60 * 60 * 24 * 30)), // 1 month from start
                        new Date(),
                        companies.get(new Random().nextInt(companies.size())) // Random Company
                );
                offerService.addOffer(offer);
            }

            // Fetch created students and offers
            var students = studentService.getAllStudents();
            var offers = offerService.getAllOffers();

            // Populate Applications
            for (int i = 1; i <= 10; i++) {
                ApplicationModel application = new ApplicationModel(
                        new Date(),
                        Status.values()[new Random().nextInt(Status.values().length)], // Random Status
                        null,
                        null,
                        students.get(new Random().nextInt(students.size())), // Random Student
                        offers.get(new Random().nextInt(offers.size())) // Random Offer
                );
                applicationService.addApplication(application);
            }
        };
    }
}
