package com.example.internmaster.Offer;

import com.example.internmaster.Company.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OfferService {

    private final OfferRepository offerRepository;
    private final CompanyRepository companyRepository;

    @Autowired
    public OfferService(OfferRepository offerRepository, CompanyRepository companyRepository){this.offerRepository=offerRepository;this.companyRepository=companyRepository;}

    public List<OfferModel> getAllOffers(){
        return offerRepository.findAll();
    }

    public OfferModel getOfferById(long id){
        return offerRepository.findById(id);
    }

    public void addOffer(OfferModel o){offerRepository.save(o);}

    public void deleteOfferById(long id){
        if (offerRepository.existsById(id)) {
            offerRepository.deleteById(id);
        } else {
            throw new IllegalArgumentException("Student with ID " + id + " does not exist.");
        }
    }

    public void updateOffer(long id, OfferModel newOffer){
        OfferModel offer=offerRepository.findById(id);
        if(offer!=null){
            offer.setCompany(newOffer.getCompany());
            offer.setDescription(newOffer.getDescription());
            offer.setDomaine(newOffer.getDomaine());
            offer.setDuration(newOffer.getDuration());
            offer.setTitle(newOffer.getTitle());
            offer.setType(newOffer.getType());
            offer.setStartDate(newOffer.getStartDate());
            offer.setEndDate(newOffer.getEndDate());
            offer.setPostDate(newOffer.getPostDate());
            offerRepository.save(offer);
        }else{throw new IllegalArgumentException("Offer with ID " + id + " does not exist.");}
    }

    public List<OfferModel> getCompanysOffers(long compId){
        return offerRepository.findByCompany_Id(compId);
    }
}
