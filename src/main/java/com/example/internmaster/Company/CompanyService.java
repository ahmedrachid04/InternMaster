package com.example.internmaster.Company;

import com.example.internmaster.Student.StudentModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyService {

    private final CompanyRepository companyRepository;

    @Autowired
    public CompanyService(CompanyRepository companyRepository){this.companyRepository=companyRepository;}

    public List<CompanyModel> getCompanies(){
        return companyRepository.findAll();
    }

    public Optional<CompanyModel> getCompanyById(long id){
        return companyRepository.findById(id);
    }

    public void addCompany(CompanyModel s){companyRepository.save(s);}

    public void deleteCompanyById(long id){
        if (companyRepository.existsById(id)) {
            companyRepository.deleteById(id);
        } else {
            throw new IllegalArgumentException("Student with ID " + id + " does not exist.");
        }
    }

    public void updateCompany(long id, CompanyModel newCompany){
        Optional<CompanyModel> oldCompany=companyRepository.findById(id);
        if(oldCompany.isPresent()){
            CompanyModel company=oldCompany.get();
            company.setName(newCompany.getName());
            company.setAddresse(newCompany.getAddresse());
            company.setContactEmail(newCompany.getContactEmail());
            company.setContactNumber(newCompany.getContactNumber());
            company.setFax(newCompany.getFax());
            company.setDescription(newCompany.getDescription());
            company.setLogo(newCompany.getLogo());
            company.setPassword(newCompany.getPassword());
            companyRepository.save(company);
        }else{throw new IllegalArgumentException("Company with ID " + id + " does not exist.");}
    }

}
