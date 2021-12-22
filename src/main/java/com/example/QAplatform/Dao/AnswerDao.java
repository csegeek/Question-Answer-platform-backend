package com.example.QAplatform.Dao;

import java.util.Set;

import com.example.QAplatform.Model.Entities.Author;
import com.example.QAplatform.Model.Entities.Question;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class AnswerDao {
    
    private Long ans_id;
    private String content;
    private Author user;
    private Question question;
    private Set<Author> anslike;



  

}
