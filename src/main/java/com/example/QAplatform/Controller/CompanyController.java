package com.example.QAplatform.Controller;

import java.util.List;

import com.example.QAplatform.Model.Entities.Company;
import com.example.QAplatform.Service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

 

@RestController
@RequestMapping("/company")
public class CompanyController {
    @Autowired
   private CompanyService companyService;
   
    @PostMapping("/")
    public ResponseEntity<?> saveCompany(@RequestBody Company company) {
      Company company1 = this.companyService.save(company);
     return ResponseEntity.ok(company1);
    }

    @GetMapping("/{company_id}")
    public Company getCompany( @PathVariable("company_id") Long company_id){
        return this.companyService.findById( company_id);
    }

    //getall company
   
    @GetMapping("/")
    public List<Company> getAllCompany(){
        return this.companyService.findall();
    }
    //update 
    @PutMapping("/")
    public Company updateCompany(@ RequestBody Company company)
    {
        return this.companyService.save(company);
    }
    
    //delete company
    @DeleteMapping("/{company_id}")
    public ResponseEntity<String> deleteCompany (@PathVariable("company_id") Long company_id){

        this.companyService.deleteById(company_id);
        return ResponseEntity.ok("Company Deleted Successfully!!");
    }

    
}
