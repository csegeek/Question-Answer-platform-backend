package com.example.QAplatform.Model.Entities;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="Author")
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="author_id")
    private Long author_id;

    @NotBlank(message = "username is required")
    @Column(name="authorname")
    private String username;
    
    @JsonIgnore
    @Column(name="password")
    private String password;
    
    @JsonIgnore
    @Email
    @Column(name="email")
    private String email;
 
    @Column(name="created")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY) 
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy", timezone = "UTC")
    @Temporal(TemporalType.DATE)
    private Date created=new Date(System.currentTimeMillis());
    
    @JsonIgnore
    @Column(name="enabled")
    private boolean enabled=true;
   
    @JsonIgnore
    @ToString.Exclude
    @OneToMany(mappedBy = "author", cascade = {
        CascadeType.DETACH, CascadeType.MERGE,
        CascadeType.PERSIST, CascadeType.REFRESH})
     private List<Question> questions;

}