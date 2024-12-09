package com.example.internmaster.Offer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OfferController {
    @Autowired
    private OfferService offerService;
    public OfferController(OfferService offerService){this.offerService=offerService;}
    @GetMapping("api/offers")
    public ResponseEntity<List<OfferModel>> getOffers(){
        return ResponseEntity.ok(offerService.getAllOffers());
    }

    @GetMapping("api/offer/{id}")
    public ResponseEntity<OfferModel> getById(@PathVariable("id")long id){
        return ResponseEntity.ok(offerService.getOfferById(id));
    }

    @GetMapping("api/companyoffers/{compid}")
    public ResponseEntity<List<OfferModel>> getCompanysOffers(@PathVariable("compid")long companyId){
        return ResponseEntity.ok(offerService.getCompanysOffers(companyId));
    }

    @PostMapping("api/addoffer")
    public ResponseEntity<String> addOffer(@RequestBody OfferModel offer){
        try{
            offerService.addOffer(offer);
            return ResponseEntity.ok("Offer "+offer.getId()+" added");
        }catch (IllegalArgumentException e){return ResponseEntity.badRequest().body("Invalid Body "+e.getMessage());}
    }

    @PutMapping("api/putoffer/{id}")
    public ResponseEntity<String> putOffer(@PathVariable("id") long id, @RequestBody OfferModel offer){
        try{
            offerService.updateOffer(id,offer);
            return ResponseEntity.ok("Offer "+offer.getId()+" Updated");
        }catch (IllegalArgumentException e){return ResponseEntity.badRequest().body("Invalid Body "+e.getMessage());}
    }

    @DeleteMapping("api/deleteoffer/{id}")
    public ResponseEntity<String> deleteOffer(@PathVariable("id")long id){
        try{
            offerService.deleteOfferById(id);
            return ResponseEntity.ok("Offer "+id+" Deleted");
        }catch (IllegalArgumentException e){return ResponseEntity.badRequest().body("Invalid Body "+e.getMessage());}
    }
}
