package com.example.QAplatform.Repository;

import com.example.QAplatform.Model.Entities.Topic;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface TopicRepo extends JpaRepository<Topic, Long>  {
    
}
