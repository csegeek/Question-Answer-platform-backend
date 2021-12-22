# Question Answer Platform 

A Java Backend project to build backend APIs for a question answer platform, where questions and answers for interviews of various companies are being captured.
## Technology Used
1. Java
2. Spring Boot
3. JPA with Hibernate
4. Maven
5. Postgres 
6. Herroku cloud for Deployment.
## Description 
### Entities
This platform has the following high level entities, with following relationship among
them. Broadly 1 entity correspond to 1 table in system
>1. Question - Core entity of the platform
>>2. Company - A company for which question was asked, Eg: Amazon/Microsoft
>3. Topic - Topic for which a question was being asked eg: Data Structures, Algorithms
>>3.a. Subtopic - A topic can have various subtopics. Eg: For topic Data Structures, it can
have subtopics like Stacks, Queues, Lists etc.
>>4. Answer - A questions can have multiple answers
>5. Answer_comments - Users can comment on answers, hence an answer can have multiple
comments
>>6. Question_likes - User have like a question
>7. Question_company_mapping - A question can be asked for many companies. For
example, the same question may be asked by Amazon and Microsoft. To capture this
information, we need to have this entity.
>>8. Answer_likes - Users may like an answer to a question. This data would be captured in
this table.
>9. Tags - Not all information can be captured using topics and subtopics. For example while
subtopics can be Stacks, Queues and Lists, master list of tags may contain complexities of
algorithms which could be O(n), O(logn) etc.
>>10. Question_tags - A Question can be associated with multiple tags. This table will contain
that information
>11. User - User who is posting question/answer/likes etc.
     currently no user Authentication has been implemented.

### APIs
>For scope of this Project, we have following APIs
1. CRUD APIs for all master data, which includes following entities/tables
a. Company
>b. Topics
>>c. Subtopics
>>>d. Tags
>e.User
2. /POST Questions
>a. Input
>>i. Question Text - Mandatory. Min length 50 characters, Max length 500
characters
>>ii. CompanyId - Optional
>iii. SubtopicId - Mandatory
>>iv. Tags - List of tags - Optional
>v. User ID - the Id of user submitting the question
>>b. Output
>i. ID - ID of question saved in database
>>3. /POST Answers
>a. Input
>>i. Question ID - Question for which answer is being submitted
>ii. Answer Text - Mandatory. Min length 50 characters, Max length 500
characters
>>iii. User ID- the ID of user submitting answer
>b. Output
>>i. ID - ID of answer saved in database

4. /POST Comments (Post comments for a given answer)
>a. Input
>>ii. UserID - User posting the answer - Mandatory
>>iii. Comment Text - Comment Text - Mandatory. Min length 50 characters,
Max length 500 characters
>b. Output
>>i. ID - ID of comment saved in database

5. /POST Question_likes (For a user to like a given question)
>i. QuestionID - Question which is being liked
>>ii. UserId - ID of user liking the question
>6. /POST Answer_likes (For a user liking the given answer)
>>a. Input
>ii. UserId - ID of user liking the answer
>>7. /GET Filter_Questions - Returns list of questions based on the combination of following
query parameters
>a. Input
>>i. Companies - List of companies - Optional
>ii. Subtopics - List of subtopics - Optional
>>iii. Likes - Questions with more votes than votes sent as input - Optional
>  iv. Date - Questions asked after a given date - Optional
>v. Tags - List of tags - - Optional
b. Output
>i. Question ID
>>ii. Question Text
>iii. Companies - List of companies for which the question was asked
>>iv. Likes - Number of likes of the question
>v. Answer - Answer with most likes for the given question
>>vi. Tags - Tags associated with the given question
8. /GET Question - Get following details of a question for a given question id
>a. Question Text
>>b. List of answers for the given question with following details
>ii. User Id of user who answered the question
>>iii. Number of likes for the answer
>iv. List of comments of the answer, along with date and user who made the
comment
>c. Number of likes that the question has
>>d. Companies for which the question was asked
>e. Tags for the question
>>f. Topics for the question
## Release History
### Version 0.0 /22/12/2021
 
