package com.example.QAplatform.Controller;

import java.util.List;
import java.util.Set;

import com.example.QAplatform.Model.Entities.Question;
import com.example.QAplatform.Model.JSONObj.FilteredQuestion;
import com.example.QAplatform.Model.JSONObj.GetQuestion;
import com.example.QAplatform.Model.JSONObj.QueLike;
import com.example.QAplatform.Service.QuestionService;
import com.turkraft.springfilter.boot.Filter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/Question")
public class QuestionController {
    @Autowired
    private QuestionService questionService;
    
   
    @PostMapping
    public ResponseEntity<?> postquestion( @RequestBody Question question){
        Question q=this.questionService.addQuestion(question);
        Long id=q.getQue_id();
        return ResponseEntity.ok(id);
    }
 
    @GetMapping
    public Set<Question> getquestions(){
        return this.questionService.getQuestions();
    }
    
  
    @GetMapping("/{que_id}")
    public GetQuestion getquebyid( @PathVariable Long que_id){
        return this.questionService.getbyid(que_id);

    }


  @GetMapping("/Filter_Questions")

    public List<FilteredQuestion> getfiltered(@Filter Specification<Question> spec ){
        return this.questionService.getfiltered(spec);
    }


    @PostMapping("/like")
    public ResponseEntity<?> addquelike( @RequestBody QueLike quelike){
    
        this.questionService.addlike(quelike);
        return ResponseEntity.ok(" like added to question ");
    }
    



}
