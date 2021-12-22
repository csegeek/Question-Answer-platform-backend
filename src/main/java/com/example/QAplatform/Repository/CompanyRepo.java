package com.example.QAplatform.Repository;

import com.example.QAplatform.Model.Entities.Company;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface CompanyRepo extends JpaRepository<Company,Long> {
    
}
