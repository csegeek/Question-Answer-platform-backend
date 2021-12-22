package com.example.QAplatform.Service.Implimentation;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import com.example.QAplatform.Model.Entities.Answer;
import com.example.QAplatform.Model.Entities.Author;
import com.example.QAplatform.Model.Entities.Company;
import com.example.QAplatform.Model.Entities.Question;
import com.example.QAplatform.Model.Entities.Subtopic;
import com.example.QAplatform.Model.Entities.Tags;
import com.example.QAplatform.Model.JSONObj.FilteredQuestion;
import com.example.QAplatform.Model.JSONObj.GetAnsfrQue;
import com.example.QAplatform.Model.JSONObj.GetQuestion;
import com.example.QAplatform.Model.JSONObj.QueLike;
import com.example.QAplatform.Repository.CompanyRepo;
import com.example.QAplatform.Repository.QuestionRepo;
import com.example.QAplatform.Repository.TagsRepo;
import com.example.QAplatform.Service.AuthorService;
import com.example.QAplatform.Service.QuestionService;
import com.example.QAplatform.Service.SubtopicService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
@Service
public class QuestionServiceImpl implements QuestionService{

  @Autowired
  private QuestionRepo questionRepo;
  @Autowired 
  private AuthorService authorService;
  @Autowired 
  private SubtopicService subtopicService;
  @Autowired 
  private CompanyRepo companyRepo;
  @Autowired
  private TagsRepo tagsRepo;
  
  @Override
    public Question addQuestion(Question question) {
       // set author
       if(question.getAuthor()!= null)
       { Author author = authorService
        .findById(question.getAuthor().getAuthor_id())
        .orElseThrow(() -> new RuntimeException("User with this id not found: " 
        + question.getAuthor().getAuthor_id()));
      question.setAuthor(author);
       }
      // set Subtopic 
      if(question.getSubtopic()!=null) {
       Subtopic subtopic =subtopicService.findById(question.getSubtopic().getSubtopic_id())
       .orElseThrow(() -> new RuntimeException(" Subtopic with this id not found : " 
       + question.getSubtopic().getSubtopic_id()) );
       question.setSubtopic(subtopic);
      }

      if(question.getCompanies() !=null){
        Set<Company> companyinput=question.getCompanies();
        List<Long> companyid=new ArrayList<>();
        for(Company cmp:companyinput){
              companyid.add(cmp.getCompany_id());
        }
        question.setCompanies( new HashSet<>(this.companyRepo.findAllById(companyid)) );
        
      }

      if(question.getTags() !=null){
        Set<Tags> tagsinput=question.getTags();
        List<Long> tagsid=new ArrayList<>();
        for(Tags tg:tagsinput){
              tagsid.add(tg.getTags_id());
        }
      question.setTags(new HashSet<>(this.tagsRepo.findAllById(tagsid)));

      }
      
       return this.questionRepo.save(question);
    }


    @Override
    public Question updateQuestion(Question question) {
        return this.questionRepo.save(question);
    }

    @Override
    public Set<Question> getQuestions() {
      return new HashSet<> (this.questionRepo.findAll()) ;
    }

    
    @Override
    public Question getQuestion(Long que_id) {
     return this.questionRepo.findById(que_id).get();

    }

    @Override
    public Optional<Question> findById(Long que_id) {
      return this.questionRepo.findById(que_id);
    }

    @Override
    public void  addlike(QueLike quelike) {
       Question question =questionRepo.getById(quelike.getQue_id());
       if(question !=null){
         question.addlikes(authorService.getById(quelike.getUser_id()) );
       }
       this.questionRepo.save(question);

   
    }

	@Override
	public GetQuestion getbyid(Long que_id) {

    // Null values may return null poinetr exception ........
	 
    Question question= this.questionRepo.getById(que_id);
   
     GetQuestion getQuestion=new GetQuestion();

  
    if(question != null){
    getQuestion.setQuestionText(question.getBody());
   
    List<Answer> anslist =question.getAnswers();
     List<GetAnsfrQue> getanslist=new ArrayList<>();
 //setting answer
  for (Answer ans  : anslist) {
 GetAnsfrQue getans=new GetAnsfrQue();
 getans.setAnswerText(ans.getContent());
 getans.setAnswerdBy(ans.getAuthor().getAuthor_id());
 getans.setAnslikes(ans.getAnslike().size());
 getans.setComments(ans.getComments());

 getanslist.add(getans);
    
  }
getQuestion.setAnswer(getanslist);
getQuestion.setQueslikes(question.getQuelike().size());

//setting companies;
List<String> cmpnystrng=new ArrayList<>();
Set<Company> companies=question.getCompanies();

for(Company cmp:companies){
  cmpnystrng.add(cmp.getCompany_name());
}
getQuestion.setCompanies(cmpnystrng);

//setting tags
List<String> tagstring=new ArrayList<>();
Set<Tags>  tags=question.getTags();
for(Tags tg:tags){
  tagstring.add(tg.getName());
}
  getQuestion.setTags(tagstring);

  //setting topics
getQuestion.setTopic(question.getTopic().getTopic_name());



return getQuestion;

    }

   return null;
    

	}

  @Override
  public List<FilteredQuestion> getfiltered(Specification<Question> spec) {

      List<Question> questions=this.questionRepo.findAll(spec);

      List<FilteredQuestion> filtrdqstns=new ArrayList<>();
     if(questions!=null){
     
      for( Question qstn:questions){

        FilteredQuestion filtrqstn=new FilteredQuestion();

     filtrqstn.setQue_id(qstn.getQue_id());
     filtrqstn.setQuebody(qstn.getBody());

     //setting company string
     List<String> companystring=new ArrayList<>();
       Set<Company> companies=qstn.getCompanies();
       for(Company cmp:companies){
     companystring.add(cmp.getCompany_name());

       }
       filtrqstn.setCompanies(companystring);
       // setting likes
       filtrqstn.setLikes(qstn.getQuelike().size());
    //setting mostliked ans
  List<Answer> answers=qstn.getAnswers();
  int maxlike=0;
  String anstext=null;
  for( Answer ans:answers){
    int likes=ans.getAnslike().size();
     if(likes>maxlike){
       maxlike=likes;
       anstext=ans.getContent();
     }
  }
   filtrqstn.setAnswers(anstext);
  // setting tags
  Set<Tags> tags=qstn.getTags();
  List<String> tagstring=new ArrayList<>();
  for(Tags tgs:tags){
    tagstring.add(tgs.getName());
  }
  filtrqstn.setTags(tagstring);

  // adding to list
  filtrdqstns.add(filtrqstn);
       }
   
  
      }
      
      return filtrdqstns;
     
  }

 
  


}
