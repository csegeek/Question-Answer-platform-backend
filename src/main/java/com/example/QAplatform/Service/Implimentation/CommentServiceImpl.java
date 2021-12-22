package com.example.QAplatform.Service.Implimentation;

import java.util.HashSet;
import java.util.Set;

import com.example.QAplatform.Model.Entities.Answer;
import com.example.QAplatform.Model.Entities.Author;
import com.example.QAplatform.Model.Entities.Comment;
import com.example.QAplatform.Repository.CommentRepo;
import com.example.QAplatform.Service.AnswerService;
import com.example.QAplatform.Service.AuthorService;
import com.example.QAplatform.Service.CommentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class CommentServiceImpl implements CommentService{
     @Autowired
    private CommentRepo commentRepo;
     
    @Autowired
    private  AuthorService authorService;
     @Autowired 
     private AnswerService answerService;
  

    @Override
    public Comment addComment(Comment comment) {
       
        //setuser
        if(comment.getAuthor()!= null)
        { Author author = this.authorService
         .findById(comment.getAuthor().getAuthor_id())
         .orElseThrow(() -> new RuntimeException("User with this id not found ") );
       comment.setAuthor(author);
  }
        //setcomment

       if(comment.getAnswer()!=null){
          Answer answer =this.answerService.findById(comment.getAnswer().getAns_id() )
        .orElseThrow(() -> new RuntimeException("Answer with this id not found ") );   
      
        comment.setAnswer(answer);
       } 
      
   return this.commentRepo.save( comment );

    }


    @Override
    public Set<Comment> getcomments() {
       return new HashSet<>(this.commentRepo.findAll() );
    }

    
}
