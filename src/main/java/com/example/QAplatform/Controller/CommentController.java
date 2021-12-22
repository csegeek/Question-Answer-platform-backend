package com.example.QAplatform.Controller;

import java.util.Set;

import com.example.QAplatform.Model.Entities.Comment;
import com.example.QAplatform.Service.CommentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Comment" )


public class CommentController {

@Autowired
 private CommentService commentService;


@PostMapping("/")
public ResponseEntity<?> postcomment( @RequestBody Comment comment){
   return ResponseEntity.ok(this.commentService.addComment(comment).getComment_id());
}

   

@GetMapping("/")
public Set<Comment> getComments(){
    return this.commentService.getcomments();
}


}
