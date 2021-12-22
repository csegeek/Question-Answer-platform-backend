package com.example.QAplatform.Model.JSONObj;

import java.util.List;

import lombok.Data;

@Data
public class FilteredQuestion {
  
    private Long que_id;

    private String quebody;
    
    private String  answers;

    private int likes;

    private List<String> companies;

    private List<String> tags;

}
