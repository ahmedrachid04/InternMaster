package com.example.internmaster.Offer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OfferRepository extends JpaRepository<OfferModel, Long> {
    List<OfferModel> findByCompany_Id(long id);
}
