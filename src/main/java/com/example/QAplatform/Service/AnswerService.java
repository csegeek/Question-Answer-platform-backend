package com.example.QAplatform.Service;

import java.util.Optional;
import java.util.Set;

import com.example.QAplatform.Model.Entities.Answer;
import com.example.QAplatform.Model.JSONObj.AnsLike;

public interface AnswerService {

     public Answer addAnswer(Answer answer); 

     public Set<Answer> getAnswers();

     public Optional<Answer> findById(Long ans_id);

     public Answer getById( Long ans_id);

     public void addlike( AnsLike anslike);
}
