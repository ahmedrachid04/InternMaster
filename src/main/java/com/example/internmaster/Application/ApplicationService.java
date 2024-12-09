package com.example.internmaster.Application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ApplicationService {

    private final ApplicationRepository applicationRepository;

    @Autowired
    public ApplicationService(ApplicationRepository applicationRepository){
        this.applicationRepository=applicationRepository;
    }

    public void addApplication(ApplicationModel a){
        applicationRepository.save(a);
    }

    public List<ApplicationModel> getAllApplications(){
        return applicationRepository.findAll();
    }

    public ApplicationModel getApplcationById(long id){
        return applicationRepository.findById(id);
    }

    public void deleteApplication(long id){
        applicationRepository.deleteById(id);
    }

    public void updateApplication(long id, ApplicationModel newApp){
        ApplicationModel app=applicationRepository.findById(id);
        if(app!=null){
            app.setApplicationDate(newApp.getApplicationDate());
            app.setApplicationLetter(newApp.getApplicationLetter());
            app.setCv(newApp.getCv());
            app.setStatus(newApp.getStatus());
            app.setStudent(newApp.getStudent());
            app.setOffer(newApp.getOffer());
            applicationRepository.save(app);
        }else{throw new IllegalArgumentException("Offer with ID " + id + " does not exist.");}
    }

    public List<ApplicationModel> getOffersApplications(long ofId){
        return applicationRepository.findByOffer_id(ofId);
    }

    public List<ApplicationModel> getStudentsApplications(long studentId){
        return applicationRepository.findByStudent_Id(studentId);
    }
}
