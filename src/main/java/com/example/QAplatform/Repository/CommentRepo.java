package com.example.QAplatform.Repository;

import com.example.QAplatform.Model.Entities.Comment;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepo extends JpaRepository<Comment ,Long>  {
    
}
