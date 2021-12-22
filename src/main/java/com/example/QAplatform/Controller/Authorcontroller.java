package com.example.QAplatform.Controller;
import java.util.Optional;

import com.example.QAplatform.Model.Entities.Author;
import com.example.QAplatform.Service.AuthorService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class Authorcontroller {

      @Autowired
      private AuthorService authorService;


    @PostMapping("/") 
        public ResponseEntity<?> createuser(@RequestBody Author author)
        {
            return ResponseEntity.ok(this.authorService.createuser(author).getAuthor_id());
        }
    @PutMapping("/")
    public ResponseEntity<?> updateuser( @RequestBody Author author){
         this.authorService.updateuser(author);
         return ResponseEntity.ok("User Updated Succesful !");
    }

     @GetMapping("/{user_id}")
     public Optional<Author> findbyid(@PathVariable Long user_id ){
         return this.authorService.findById(user_id);
     }

     @DeleteMapping("/{user_id}")
     public ResponseEntity<String> deletebyid( @PathVariable Long user_id)
    {
        this.authorService.deleteuser(user_id);
        return ResponseEntity.ok("user deleted Sucessfully");
    }

}
