package com.example.QAplatform.Controller;

import java.util.List;

import com.example.QAplatform.Model.Entities.Subtopic;
import com.example.QAplatform.Service.SubtopicService;

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
@RequestMapping("/Subtopic")
public class SubtopicController {
    @Autowired
    private SubtopicService subtopicService ;

    @PostMapping("/")
    public ResponseEntity<?> createSubtopic( @RequestBody Subtopic subtopic){
       

         return ResponseEntity.ok(this.subtopicService.saveSubtopic(subtopic));
    }
    
    @PutMapping("/")
    public ResponseEntity<String> updateSubTopic(@RequestBody Subtopic subtopic)
    {
        this.subtopicService.saveSubtopic(subtopic);
        return ResponseEntity.ok("SubTopic Updated");

    }
    
    @GetMapping("/")
    public List<Subtopic> readall(){
        return this.subtopicService.findall();
    }

    @GetMapping("/{subtopic_id}")
   public Subtopic readbyid(@PathVariable Long subtopic_id){
       return this.subtopicService.findSubtopic(subtopic_id);
   }

   @DeleteMapping("/{subtopic_id}")
       public ResponseEntity<String> deletebyid(@PathVariable Long subtopic_id){
           this.subtopicService.deleteByid(subtopic_id);
           return ResponseEntity.ok("Deleted Sucessfully");
       }

}
