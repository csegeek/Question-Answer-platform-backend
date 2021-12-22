package com.example.QAplatform.Model.Entities;
import static javax.persistence.FetchType.LAZY;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonBackReference;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="Ans_Comment")

public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long comment_id;
    @NotEmpty
    @Size( min=50, max=500 ,message="Comments can't be less than 50 and more than 500 chars")
    private String text;

    @JsonBackReference
    @ToString.Exclude
    @ManyToOne( cascade = {
        CascadeType.DETACH, CascadeType.MERGE,
        CascadeType.PERSIST, CascadeType.REFRESH} ,fetch = LAZY)
    @JoinColumn(name = "ans_id", referencedColumnName = "ans_id")
    
    private Answer answer;
   
   @Temporal(TemporalType.DATE)
   private Date createdDate =new Date(System.currentTimeMillis());

   @ToString.Exclude
    @ManyToOne(cascade = {
        CascadeType.DETACH, CascadeType.MERGE,
        CascadeType.PERSIST, CascadeType.REFRESH},fetch = LAZY)
    @JoinColumn(name = "author_id", referencedColumnName = "author_id" )
    private Author author;

}