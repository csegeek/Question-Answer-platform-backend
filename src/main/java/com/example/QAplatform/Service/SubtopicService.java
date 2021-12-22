package com.example.QAplatform.Service;

import java.util.List;
import java.util.Optional;

import com.example.QAplatform.Model.Entities.Subtopic;


public interface SubtopicService {
   
    Subtopic saveSubtopic(Subtopic subtopic);
     Subtopic findSubtopic( Long subtopic_id);
     List<Subtopic> findall();
     void deleteByid(Long subtopic_id);
    Optional<Subtopic> findById(Long subtopic_id);

    
    
}
