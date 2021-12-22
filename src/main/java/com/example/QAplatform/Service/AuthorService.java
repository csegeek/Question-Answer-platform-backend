package com.example.QAplatform.Service;

import java.util.Optional;

import com.example.QAplatform.Model.Entities.Author;

public interface AuthorService {
    
   
    public Author createuser( Author author);
    
   public Author updateuser(Author author);

   public  Optional<Author> findById(Long id);

    public Author getById( Long id);
     public void deleteuser( Long id);

  

}
