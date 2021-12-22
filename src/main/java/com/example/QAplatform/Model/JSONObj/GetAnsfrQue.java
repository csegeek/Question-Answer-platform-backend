package com.example.QAplatform.Model.JSONObj;

import java.util.Set;

import com.example.QAplatform.Model.Entities.Comment;

import lombok.Data;

@Data

public class GetAnsfrQue {
  
    private String AnswerText;

    private Long AnswerdBy;
 
    private int Anslikes;
 
    private Set<Comment> comments;
 
  
}
