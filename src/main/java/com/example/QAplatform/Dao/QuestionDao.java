package com.example.QAplatform.Dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.example.QAplatform.Model.Entities.Answer;
import com.example.QAplatform.Model.Entities.Author;
import com.example.QAplatform.Model.Entities.Company;
import com.example.QAplatform.Model.Entities.Tags;
import com.example.QAplatform.Model.Entities.Topic;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class QuestionDao {
    private Long que_id;
    private String body;
    private Author user;
    private List<Answer> answers = new ArrayList<>();
    private List<Topic> topics = new ArrayList<>();
    private Set<Tags> tags;
    private Set<Company> companies;
    private Set<Author> quelike;

}
