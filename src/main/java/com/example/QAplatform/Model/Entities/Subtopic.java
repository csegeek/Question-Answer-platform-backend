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
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="Subtopic")

public class Subtopic {
    @Id
    @Column(name="subtopic_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
      Long subtopic_id;
    @Column(name="subtopic_name")
    String subtopic_name;

    @JsonIgnore
    @ToString.Exclude
    @OneToMany(mappedBy = "subtopic", cascade = {
      CascadeType.DETACH, CascadeType.MERGE,
      CascadeType.PERSIST, CascadeType.REFRESH} )

   private List<Question> questions;

}
