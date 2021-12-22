package com.example.QAplatform.Controller;

import java.util.List;

import com.example.QAplatform.Model.Entities.Tags;
import com.example.QAplatform.Service.TagsService;

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
@RequestMapping("/Tags")
public class TagsController {
    @Autowired
    private TagsService tagsService;

    @PostMapping("/")
    public Tags create(@RequestBody Tags tags){
        return this.tagsService.save(tags);
    }
    
    @PutMapping("/")
    public ResponseEntity<String> Update(@RequestBody Tags tags){
        this.tagsService.save(tags);
        return ResponseEntity.ok("Updated Sucessfully !");
    }
    
    @GetMapping("/{tags_id}")
    public Tags read( @PathVariable Long tags_id){
        return this.tagsService.findById(tags_id);
    }
    
    @GetMapping("/")
    public List<Tags> readall(){
        return this.tagsService.findall();
    }

    @DeleteMapping("/{tags_id}")
    public ResponseEntity<String> delete(@PathVariable Long tags_id)
    {
         this.tagsService.deleteById(tags_id);
         return ResponseEntity.ok("Tag Deleted Sucessfully !");

    }


}
