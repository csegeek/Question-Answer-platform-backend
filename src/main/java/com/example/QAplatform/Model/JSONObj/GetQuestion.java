package com.example.QAplatform.Model.JSONObj;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.Data;

@Data
@JsonPropertyOrder({ "QuestionText", "answer", "Queslikes","companies" ,"tags","topics"})
public class GetQuestion {

   private String QuestionText;

  private List<GetAnsfrQue> answer ;

   private int Queslikes;

   private List<String> companies;

   private List<String> tags;
   
   private String  topic;
   




    
}
