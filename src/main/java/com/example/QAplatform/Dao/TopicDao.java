package com.example.QAplatform.Dao;

import java.util.ArrayList;
import java.util.List;

import com.example.QAplatform.Model.Entities.Question;
import com.example.QAplatform.Model.Entities.Subtopic;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class TopicDao {

   private int topic_id;
   private  String topic_name;
    private List<Subtopic> subtopic = new ArrayList<>();
    private Question question;

}
