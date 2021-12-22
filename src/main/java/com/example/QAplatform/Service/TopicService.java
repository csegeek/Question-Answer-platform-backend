package com.example.QAplatform.Service;

import java.util.List;

import com.example.QAplatform.Model.Entities.Topic;



public interface TopicService {
    
    Topic save(Topic topic);

    List<Topic> findall( );

    Topic findById( Long topic_id);

    void deleteById( Long topic_id) ;
    
}
