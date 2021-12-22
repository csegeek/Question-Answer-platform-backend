package com.example.QAplatform.Repository;
import com.example.QAplatform.Model.Entities.Question;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionRepo extends JpaRepository<Question, Long>,JpaSpecificationExecutor<Question>{
    


    
}
