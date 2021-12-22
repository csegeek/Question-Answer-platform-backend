package com.example.QAplatform.Controller;

import java.util.List;

import com.example.QAplatform.Model.Entities.Topic;
import com.example.QAplatform.Service.TopicService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/Topic")
public class TopicController {


    @Autowired
     private TopicService topicService; 

    @PostMapping(value="/")
    public ResponseEntity<?> postTopic(@RequestBody Topic topic) {
       
        Topic topic1=this.topicService.save(topic);
        return ResponseEntity.ok(topic1);
    }
    @GetMapping("/")
    public List<Topic> gettopics(){
        return this.topicService.findall();
    }
    
    @GetMapping("/{topic_id}")
    public Topic gettopic(@PathVariable Long topic_id){
        return this.topicService.findById(topic_id);
    }
    
    @PutMapping("/")
    public ResponseEntity<String> updateTopic(@RequestBody Topic topic) {
       
       this.topicService.save(topic);
        return ResponseEntity.ok("Updated Sucessfully");
    }

    @DeleteMapping("/{topic_id}")
    public ResponseEntity<String> deletetopic(@PathVariable Long topic_id){
              this.topicService.deleteById(topic_id);
           return   ResponseEntity.ok("Topic Deleted Successfully!!");
    }
}
