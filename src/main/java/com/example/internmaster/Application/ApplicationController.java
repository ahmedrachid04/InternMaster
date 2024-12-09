package com.example.internmaster.Application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ApplicationController {
    @Autowired
    private ApplicationService applicationService;

    public ApplicationController(ApplicationService applicationService){this.applicationService=applicationService;}

    @GetMapping("api/applications")
    public ResponseEntity<List<ApplicationModel>> getAll(){
        return ResponseEntity.ok(applicationService.getAllApplications());
    }

    @GetMapping("api/application/{id}")
    public ResponseEntity<ApplicationModel> getById(@PathVariable("id")long id){
        return ResponseEntity.ok(applicationService.getApplcationById(id));
    }

    @GetMapping("api/offerapplications/{offerid}")
    public List<ApplicationModel> getOfferApplications(@PathVariable("offerid")long offerId){
        return applicationService.getOffersApplications(offerId);
    }

    @GetMapping("api/studentapplications/{studid}")
    public List<ApplicationModel> getStudentApplications(@PathVariable("studid")long studentId){
        return applicationService.getStudentsApplications(studentId);
    }

    @PostMapping("api/addapplication")
    public ResponseEntity<String> addStudent(@RequestBody ApplicationModel application){
        try{
            applicationService.addApplication(application);
            return ResponseEntity.ok("Application added");
        }catch(IllegalArgumentException e){return ResponseEntity.badRequest().build();}
    }

    @PutMapping("api/putapplication/{id}")
    public ResponseEntity<String> putApplication(@PathVariable("id")long id, @RequestBody ApplicationModel application){
        try{
            applicationService.updateApplication(id,application);
            return ResponseEntity.ok("Application updated");
        }catch(IllegalArgumentException e){return ResponseEntity.badRequest().body("Invalid Body "+e.getMessage());}
    }

    @DeleteMapping("api/deleteapplication/{id}")
    public ResponseEntity<String> deleteApplication(@PathVariable("id")long id){
        try{
            applicationService.deleteApplication(id);
            return ResponseEntity.ok("Application " + id + " Deleted");
        }catch (IllegalArgumentException e){return ResponseEntity.notFound().build();}
    }
}
