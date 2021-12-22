package com.example.QAplatform.Service;

import java.util.Set;

import com.example.QAplatform.Model.Entities.Comment;

public interface CommentService {

    public Comment  addComment(Comment  comment); 

    public Set<Comment> getcomments();
    

    
}
