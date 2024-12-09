package com.example.internmaster.Application;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ApplicationRepository extends JpaRepository<ApplicationModel, Long> {
    List<ApplicationModel> findByStudent_Id(long id);
    List<ApplicationModel> findByOffer_id(long id);
    ApplicationModel findById(long id);
}
