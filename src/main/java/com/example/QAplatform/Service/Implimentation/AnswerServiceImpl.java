package com.example.QAplatform.Service.Implimentation;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import com.example.QAplatform.Model.Entities.Answer;
import com.example.QAplatform.Model.Entities.Author;
import com.example.QAplatform.Model.Entities.Question;
import com.example.QAplatform.Model.JSONObj.AnsLike;
import com.example.QAplatform.Repository.AnswerRepo;
import com.example.QAplatform.Service.AnswerService;
import com.example.QAplatform.Service.AuthorService;
import com.example.QAplatform.Service.QuestionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AnswerServiceImpl implements AnswerService  {
   
    @Autowired
  private  AnswerRepo answerRepo;
    @Autowired
  private  AuthorService authorService;
   @Autowired 
   private QuestionService questionService;

    @Override
    public Answer addAnswer(Answer answer) {
        if(answer.getAuthor()!= null)
        { Author author = authorService
         .findById(answer.getAuthor().getAuthor_id())
         .orElseThrow(() -> new RuntimeException("User with this id not found: " 
         + answer.getAuthor().getAuthor_id()));
       answer.setAuthor(author);
        }

       if(answer.getQuestion()!=null){
           Question question =this.questionService.findById(answer.getQuestion().getQue_id())
        .orElseThrow(() -> new RuntimeException("Question with this id not found ") );
       
        answer.setQuestion(question);
       } 


       return this.answerRepo.save(answer);
        
    }


    @Override
    public Set<Answer> getAnswers() {
       return new HashSet<> (this.answerRepo.findAll()) ;
    }


    @Override
    public Optional<Answer> findById(Long ans_id) {
         return this.answerRepo.findById(ans_id);
    }


    @Override
    public Answer getById(Long ans_id) {
      return this.answerRepo.getById(ans_id);
    }


    @Override
    public void addlike(AnsLike anslike) {
      Answer answer=this.answerRepo.getById(anslike.getAns_id());
      System.out.println( "ans service invoked ");
       if(answer!=null){
         answer.addlikes(authorService.getById(anslike.getUser_id()));
       }
      this.answerRepo.save(answer);
   
      
    }

    
    
    
}
