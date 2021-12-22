package com.example.QAplatform.Service.Implimentation;

import java.util.List;

import com.example.QAplatform.Model.Entities.Topic;
import com.example.QAplatform.Repository.TopicRepo;
import com.example.QAplatform.Service.TopicService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopicServiceImpl implements TopicService{

   @Autowired
   private TopicRepo topicRepo;
   
   
    @Override
    public Topic save(Topic topic) {
       
        return topicRepo.save(topic);
    }

    @Override
    public List<Topic> findall() {
      return  topicRepo.findAll();
    }

    @Override
    public Topic findById(Long topic_id) {
       return topicRepo.getById(topic_id);
    }

    @Override
    public void deleteById(Long topic_id) {
      topicRepo.deleteById(topic_id);
        
    }

    
}
