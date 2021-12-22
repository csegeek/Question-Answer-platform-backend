package com.example.QAplatform.Service;

import java.util.List;

import com.example.QAplatform.Model.Entities.Tags;



public interface TagsService  {


    Tags save(Tags tags);

    List<Tags> findall( );

    Tags findById( Long tags_id);

    void deleteById( Long tags_id) ;
    
    
}
