package com.example.internmaster.Company;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CompanyController {
    @Autowired
    CompanyService companyService;
    public CompanyController(CompanyService companyService){
        this.companyService=companyService;
    }

    @GetMapping(path = "/api/companies")
    public ResponseEntity<List<CompanyModel>> getAllCompanies() {
        List<CompanyModel> companies = companyService.getCompanies();
        return ResponseEntity.ok(companies);
    }


    @GetMapping(path = "/api/company/{compid}")
    public ResponseEntity<CompanyModel> getCompanyById(@PathVariable("compid") long id) {
        return companyService.getCompanyById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }


    @GetMapping(path = "api/offerscompany/{offerid}")
    public ResponseEntity<CompanyModel> getCompanyByOffer(@PathVariable("offerid")long id){
        CompanyModel company=companyService.findCompanyByOffer(id);
        if (company != null) {
            return ResponseEntity.ok(company);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping(path = "api/putcompany/{compid}")
    public ResponseEntity<String> updateCompany(@PathVariable("compid")long id, @RequestBody CompanyModel companyModel){
        try{
            companyService.updateCompany(id, companyModel);
            return ResponseEntity.ok("Company " + id + " Updated");
        }catch (IllegalArgumentException e){return ResponseEntity.notFound().build();}
    }

    @DeleteMapping(path = "api/deletecompany/{compid}")
    public ResponseEntity<String> deleteCompany(@PathVariable("compid")long id){
        try{
            companyService.deleteCompanyById(id);
            return ResponseEntity.ok("Company " + id + " Deleted");
        }catch (IllegalArgumentException e){return ResponseEntity.notFound().build();}
    }

    @PostMapping(path = "api/addcompany")
    public ResponseEntity<String> addCompany(@RequestBody CompanyModel companyModel){
        try{
            companyService.addCompany(companyModel);
            return ResponseEntity.ok("Company " + companyModel.getName() + " Added");
        }catch (IllegalArgumentException e){return ResponseEntity.badRequest().body("Invalid Body "+e.getMessage());}
    }

}

