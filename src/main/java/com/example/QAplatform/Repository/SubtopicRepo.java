package com.example.QAplatform.Repository;

import com.example.QAplatform.Model.Entities.Subtopic;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface SubtopicRepo extends JpaRepository<Subtopic,Long> {
    
}
