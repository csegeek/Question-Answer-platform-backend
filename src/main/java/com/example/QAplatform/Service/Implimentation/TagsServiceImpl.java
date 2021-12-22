package com.example.QAplatform.Service.Implimentation;

import java.util.List;
import com.example.QAplatform.Model.Entities.Tags;
import com.example.QAplatform.Repository.TagsRepo;
import com.example.QAplatform.Service.TagsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TagsServiceImpl implements TagsService{
  

    @Autowired
    TagsRepo tagsRepo;

    @Override
    public Tags save(Tags tags) {
        Tags tag=new Tags();
        tag.setTags_id(tags.getTags_id());
        tag.setName(tags.getName());
        tag.setQuestions(tags.getQuestions());

        return tagsRepo.save(tag);
    }

    @Override
    public List<Tags> findall() {
    
        return tagsRepo.findAll();
    }

    @Override
    public Tags findById(Long tags_id) {
       
        return tagsRepo.getById(tags_id);
    }

    @Override
    public void deleteById(Long tags_id) {
        tagsRepo.deleteById(tags_id);
        
    }
    
}
