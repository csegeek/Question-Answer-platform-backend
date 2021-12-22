package com.example.QAplatform.Service;

import java.util.List;

import com.example.QAplatform.Model.Entities.Company;



public interface CompanyService {
    
    Company  save(Company company);

    List<Company> findall( );

    Company findById( Long company_id);

    void deleteById( Long company_Id) ;
    

}
