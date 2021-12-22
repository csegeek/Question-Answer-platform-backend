package com.example.QAplatform.Repository;

import com.example.QAplatform.Model.Entities.Answer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface AnswerRepo extends JpaRepository<Answer,Long> {
    
}
