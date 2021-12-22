package com.example.QAplatform.Dao;

import java.util.Set;

import com.example.QAplatform.Model.Entities.Question;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor


public class CompanyDao {
    
    private Long company_id;
    private String company_name;
    
    private Set<Question> questions;
}
