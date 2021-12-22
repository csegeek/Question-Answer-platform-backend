package com.example.QAplatform.Controller;

import java.util.Set;

import com.example.QAplatform.Model.Entities.Answer;
import com.example.QAplatform.Model.JSONObj.AnsLike;
import com.example.QAplatform.Service.AnswerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Answer")
public class AnswerController {

    @Autowired 
    AnswerService answerService;
    
    @PostMapping("/")
    public ResponseEntity<?> postanswer ( @RequestBody Answer answer){
        return ResponseEntity.ok(this.answerService.addAnswer(answer).getAns_id());


    }

    @GetMapping("/")
    public Set<Answer> getanswer(){
        return this.answerService.getAnswers();
    }

    @PostMapping("/like")
    public ResponseEntity<?> addlike( @RequestBody AnsLike anslike){
        System.out.println(" addlike invoked ");
        this.answerService.addlike(anslike);
        return ResponseEntity.ok(" AnsLike added Sucessfully");
    }

}
