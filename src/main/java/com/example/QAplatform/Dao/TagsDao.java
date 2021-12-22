package com.example.QAplatform.Dao;

import java.util.Set;

import com.example.QAplatform.Model.Entities.Question;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class TagsDao {
  
    private Long tags_id;
    private String name;
    private Set<Question> questions;

}
