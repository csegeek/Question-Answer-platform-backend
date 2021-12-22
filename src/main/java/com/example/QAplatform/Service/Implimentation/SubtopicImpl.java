package com.example.QAplatform.Service.Implimentation;

import java.util.List;
import java.util.Optional;

import com.example.QAplatform.Model.Entities.Subtopic;
import com.example.QAplatform.Repository.SubtopicRepo;
import com.example.QAplatform.Service.SubtopicService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class SubtopicImpl implements SubtopicService{
    @Autowired
     private SubtopicRepo subtopicRepo;

    @Override
    public void deleteByid(Long subtopic_id) {
        subtopicRepo.deleteById(subtopic_id);
        
    }

    @Override
    public Subtopic findSubtopic(Long subtopic_id) {
         
        return  subtopicRepo.getById(subtopic_id);
    }

    @Override
    public List<Subtopic> findall() {
        
        return subtopicRepo.findAll();
    }

    @Override
    public Subtopic saveSubtopic(Subtopic subtopic) {
      
        return subtopicRepo.save(subtopic);

    }

    @Override
    public Optional<Subtopic> findById(Long subtopic_id) {
       
        return subtopicRepo.findById(subtopic_id);
    }
    

}
    

