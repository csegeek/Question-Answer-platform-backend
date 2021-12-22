package com.example.QAplatform.Repository;

import com.example.QAplatform.Model.Entities.Tags;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface TagsRepo extends JpaRepository<Tags ,Long> {
    
}
