package com.example.QAplatform.Model.Entities;


import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Topic")
public class Topic {
    @Id
    @Column(name="topic_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long topic_id;
    @Column(name="topic_name")
   private  String topic_name;

    
  @JsonIgnore
  @OneToMany(mappedBy = "topic", cascade = {
    CascadeType.DETACH, CascadeType.MERGE,
    CascadeType.PERSIST, CascadeType.REFRESH})
 private List<Question> questions;
    




}
