package com.example.QAplatform.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import com.example.QAplatform.Model.Entities.Question;
import com.example.QAplatform.Model.JSONObj.FilteredQuestion;
import com.example.QAplatform.Model.JSONObj.GetQuestion;
import com.example.QAplatform.Model.JSONObj.QueLike;

import org.springframework.data.jpa.domain.Specification;

public interface QuestionService {

    public Question addQuestion(Question question);

    public Question updateQuestion(Question question);

    public Set<Question> getQuestions();

    public Question getQuestion(Long que_id);
    
    public Optional<Question> findById(Long que_id);
    
    public void addlike( QueLike quelike);

    public GetQuestion getbyid( Long que_id);

    public List<FilteredQuestion> getfiltered( Specification<Question> spec);


}
