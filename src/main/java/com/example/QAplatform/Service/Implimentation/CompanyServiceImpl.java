package com.example.QAplatform.Service.Implimentation;

import java.util.List;

import com.example.QAplatform.Model.Entities.Company;
import com.example.QAplatform.Repository.CompanyRepo;
import com.example.QAplatform.Service.CompanyService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompanyServiceImpl implements CompanyService {

    @Autowired
    private CompanyRepo companyRepo;

    
    @Override
    public Company save(Company company) {
       return  companyRepo.save(company);
    }

    @Override
    public List<Company> findall() {
       return companyRepo.findAll();
    }

    @Override
    public Company findById(Long company_id) {
       return companyRepo.getById(company_id);
    }

    @Override
    public void deleteById(Long company_Id) {
    companyRepo.deleteById(company_Id);
        
    }
    
    
}
