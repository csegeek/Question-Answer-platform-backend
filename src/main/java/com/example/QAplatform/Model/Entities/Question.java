package com.example.QAplatform.Model.Entities;

import java.util.Date;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Question")
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "que_id")
    private Long que_id;

    @Column(name = "body", columnDefinition = "text", nullable = false)
    @NotBlank(message = "Question body can't be empty")
    @Size( min=50, max=500 ,message="question can't be less than 50 and more than 500 chars")
    private String body;
    

    @Column(name="date_posted")
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy", timezone = "UTC")
    @NotNull
    @Temporal(TemporalType.DATE)
   private Date dateposted =new Date(System.currentTimeMillis());
    // mappings 
    //@JsonManagedReference
    @ToString.Exclude
    @ManyToOne( cascade = {
        CascadeType.DETACH, CascadeType.MERGE,
        CascadeType.PERSIST, CascadeType.REFRESH})
        @JoinColumn(name = "author_id")
        private Author author;

   
        @JsonManagedReference
    @OneToMany(mappedBy = "question", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Answer> answers = new ArrayList<>();

    @ToString.Exclude
    @ManyToOne( cascade = {
        CascadeType.DETACH, CascadeType.MERGE,
        CascadeType.PERSIST, CascadeType.REFRESH})
        @JoinColumn(name = "topic_id")
   private Topic topic;
   
   
   @ToString.Exclude
   @ManyToOne( cascade = {
    CascadeType.DETACH, CascadeType.MERGE,
    CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "subtopic_id")

    private Subtopic subtopic ;


    @ToString.Exclude
    @ManyToMany(cascade = { CascadeType.MERGE,CascadeType.DETACH,
                          CascadeType.REFRESH,CascadeType.PERSIST})
    @JoinTable(
        name = "question_tags",
        joinColumns = @JoinColumn(name = "que_id"),
        inverseJoinColumns = @JoinColumn(name = "tags_id"))
    private Set<Tags> tags;

    @ToString.Exclude
    @ManyToMany(cascade = {CascadeType.MERGE, CascadeType.DETACH,
                        CascadeType.REFRESH,CascadeType.PERSIST})
        @JoinTable(
                name = "question_company_mapping",
                joinColumns = @JoinColumn(name = "que_id"),
                inverseJoinColumns = @JoinColumn(name = "company_id"))
        private Set<Company> companies;

        @ToString.Exclude
            @ManyToMany(cascade = {
                    CascadeType.MERGE, CascadeType.PERSIST,
                    CascadeType.REFRESH, CascadeType.DETACH})
            @JoinTable(
                    name = "question_like",
                    joinColumns = @JoinColumn(name = "que_id"),
                    inverseJoinColumns = @JoinColumn(name = "author_id")
            )
            private Set<Author> quelike;




// functions 

public void addTag(Tags tag) {
    if (tags == null) {
        tags = new HashSet<>();
    }
    tags.add(tag);
}

public void addAnswer(Answer answer) {
    answers.add(answer);
}

public void addlikes (Author user) {
    if (quelike== null) {
        quelike = new HashSet<>();
    }
   quelike.add(user);
}

public void removelikes(Author user) {
    quelike.remove(user);
}



    /* public boolean hasAcceptedAnswer() {
        return answers.stream().anyMatch(Answer::getIsAccepted);
    } */

public String getFormattedDate(LocalDateTime timestamp, String pattern) {
    final DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
    return timestamp.format(formatter);
}

}
