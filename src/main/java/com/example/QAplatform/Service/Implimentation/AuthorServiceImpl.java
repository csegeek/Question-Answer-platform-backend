package com.example.QAplatform.Service.Implimentation;

import java.util.Optional;

import com.example.QAplatform.Model.Entities.Author;
import com.example.QAplatform.Repository.AuthorRepo;
import com.example.QAplatform.Service.AuthorService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service 
public class AuthorServiceImpl implements AuthorService{

   @Autowired
   AuthorRepo authorRepo;

    @Override
    public Optional<Author> findById(Long id) {
        return this.authorRepo.findById(id);
        
    }

    @Override
    public Author getById(Long id) {
       return this.authorRepo.getById(id);
    }

    @Override
    public Author createuser(Author author) {
      return this.authorRepo.save(author);
    }

    @Override
    public Author updateuser(Author author) {
        return this.authorRepo.save(author);
    }

    @Override
    public void deleteuser(Long id) {
      this.authorRepo.deleteById(id);
    }
    

    
}
