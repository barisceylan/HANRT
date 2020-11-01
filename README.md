# README #

This README would normally document whatever steps are necessary to get your application up and running.

 

ÖZYEĞİN UNIVERSITY
FACULTY OF ENGINEERING
DEPARTMENT OF COMPUTER SCIENCE


CS 402

2018 Spring 


SENIOR PROJECT REPORT

Human Agent Negotiation Research Tool

By
Barış CEYLAN & Sayım Erk AYDOĞAN



Supervised By
Reyhan AYDOĞAN


Declaration of Own Work Statement/ (Plagiarism Statement)
Hereby I confirm that all this work is original and my own. I have clearly referenced/listed all sources as appropriate and given the sources of all pictures, data etc. that are not my own. I have not made any use of the essay(s) or other work of any other student(s) either past or present, at this or any other educational institution. I also declare that this project has not previously been submitted for assessment in any other course, degree or qualification at this or any other educational institution.
Student Name and Surname:	Barış Ceylan
Sayım Erk Aydoğan
Signature:	
Place, Date:	Istanbul, 16.05.2018



Abstract

  This report contains brief information and details of our senior project Human Agent Negotiation Research Tool.
  In this project, we focus on how to design a interactive negotiation framework for human-computer negotiation. Nowadays, there are not many negotiation tools that are qualified enough to satisfy the demands. There are some tools like Genius; which handles some of the requirements of the basic negotiation requests, yet they don’t acquire the interactive avatar interface while negotiating with human. So we focused on combining these shortcomings to create an advanced negotiation tool that will be sufficient for both companies and users who will use this tool.
  We come up with a solution that is java application tool which will work on these specific negotiation needs. With this negotiation tool, people will be able to create agents to fulfill the domains and issues that are going to be the key points for negotiation. Furthermore, users will find the best result for both sides with the help of our conversational negotiating avatar which has its own emotions. Also users will be able to create their own preference profiles to do proper negotiations.
  We developed this tool Java language by Eclipse program to develop this unique tool. We used the specific methods and techniques in order to create our agent, agent’s strategies, negotiation tactics and GUI design.
  As a result of our project , we have progressive GUI system which is taking the domains, issues and issue values from the users; also it includes the show off of these domains and issues properly. On the other hand, we created an agent which negotiates with users using preference profiles. We also worked on 3 different negotiation strategies for our agent. Currently our tool is working correctly and its useful for negotiation researches. 
Contents
I.	INTRODUCTION								4
II.	BACKGROUND								6
III.	PROBLEM STATEMENT							8
IV.	SOLUTION APPROACH							14
V.	RESULTS AND DISCUSSION						22
VI.	RELATED WORK								28
VII.	CONCLUSION									29
ACKNOWLEDGEMENTS								30
REFERENCES										31
APPENDIX										32










I.	   Introduction
     Nowadays, face to face negotiations are a burden for people. It is a waste of time to arrange meetings and to find the free time for both sides. In addition to these, doing Skype might be an option but still the timing problems stay. 
     We live by the rules of society; people don’t have to meet and talk face to face to make a simple negotiation. For example, bigger companies will have a lot of job applicants that they can’t handle face to face. Or in another case; when two people trying to find out the best result for both of them, how can they decide? 
     Human Agent Negotiation Research Tool is a desktop application tool that offers users to make simple negotiations; faster, efficient and interactive. There are a few tools that solve these kind of problems like Genius and IAGO. However, their solutions are not qualified enough. Genius does not contain any interactive negotiation avatar. Additionally, IAGO does not provide a domain and domain elicitation tool. In conclusion, we designed a tool which users will operate the negotiations with our agent according to the domains, issues and the preference profiles. This tool will give the best negotiating result for both sides.
     We developed this application using Java language with Eclipse program. Further; we used XML files to to save the domains, issues, specific issue values and preference profiles. Also we created a main repository XML file to keep these files in our data. In order to use these data; we worked with marshall and unmarshall methods. To get the unique data from the files; we also used Document Builder Factory and X Path. We saved the data to XML files by using JAXB which is an auxiliary framework that allows developers to map Java classes to XML files.
  We come up with a solution that will enhance the lacking parts of the Genius and IAGO. Besides, it will be a negotiation tool which will be a combination of these two tools. We took advantage of some courses that we took on the last semesters and these courses assisted us for making a Human Agent Negotiation Research Tool.
  





 We finished all of the main parts of the tool. Such as; visual GUI parts, creating and editing domain and issue system, creating unique preference profiles, agent’s strategies and tactics.Furthermore, we designed a negotiation window which includes and interactive 3D avatar with emotions. Users will be able to hear and see how the agent reacts to users offers.
       
	The detailed information about the techniques and methods we used are indicated in the below parts. Third part covers the details of the problem. On the other hand, fourth part contains the idea of how we approached to the problem statement with efficient solutions. Results and Discussions about the project specified in the fifth part. Related work according to the problem given in the sixth chapter. The final part of this report examines on conclusion of the project.
     
  
















II.	Background

The set of  techniques, tools and methods we used in our project are listed below in the section.

Object-Oriented Programing: Object oriented programming language is  a software programming model which is constructed with objects. It is a high-level language that implements objects, methods within the context to establish software programs.

MVC: MVC is a paradigm that enables users to have efficient and successful programs and divides it to three main parts; Model, View, Controller. All parts of this paradigm checks and handles the different  angles of the program. In our project , We applied MVC pattern to our code in order to view the code clearly and make developments in models.

JAVA: JAVA is an object oriented programming language that enables developers to have their project run at all JAVA platforms.

Eclipse:  Eclipse is an integrated development environment (IDE) which is widely used for JAVA programming language. It enables users to customize the existing environment by installing plug-ins from the eclipse marketplace.

JAXB: Java Architecture for XML Binding is a framework that java developers to map Java classes to XML representations. We used JAXB to save and also reach the data inside the XML files.

DocumentBuilderFactory:  It is an API that purposes to generate  DOM object trees from XML documents by parsing these programs. 

3D Avatar: 3D Avatar is a user interactive avatar which helps the user by showing agents face impressions. We are giving the option to choose whether the avatar will be female or male as well.

AudioInputStream: An audio input stream is an input stream with a specified audio format and length.
We used it in order to obtain audio and help 3D Avatar within the interaction of the user.  

CLIP:  The Clip interface is a data line whose audio data can be loaded prior to playback.

Swing:  Swing is a toolkit for GUI development in Java. It gives opportunity to the developers that they can apply graphical user interface to their programs.

XPath:  XPath is a language that finds the items in XML and determines their addressing syntax by path’s logical structure. It gives an authorization to developer to handle the documents at higher level of abstraction. It doesn’t use XML syntax, whereas it finds the searched path with some directions.

XML: XML is a data description markup language. Furthermore, it is a simple language to create, share the taken data, also it presents a readable format for human and machines.

Negotiation: It is a communication done by two or multiple people for willing to solve the issues that exists. 

GUI: It is a user interface that contains graphical elements like icons, buttons, panels etc. 

Timer: It is a vehicle for threads handled in java to schedule tasks in background of the program. These tasks can be done just once or multiple times by threads. Every thread object have a mission to carry out by orderly. 

Agent: They perform various actions continuously and autonomously on behalf of an individual or an organization.

Negotiation Tactics: We had 3 different tactics for our agent in order to operate the negotiations with user. Time based, emoji based and behaviour based negotiation strategies.

TransformerFactory: It is an instance which can be useful to produce Transformer objects. “java.xml.transform.TransformerFactory” is created by the systems feature that decides which implementation will be constituted.

Event Listeners: Event Listeners  goal is to be responsible from the events that handled such as the receives and processes changed within the GUI using Java’s Event Handling.

Repository: It is a storage area where data of the program is secured and can be changeable within any time that developer have an access to the repository.



















III.	Problem Statement

      The Human Agent Negotiation Tool project is a completely new project affected by similar projects like Genius and IAGO. We started our project because similar projects are not qualified enough and will not satisfy the users and won’t give them an efficient negotiation experience. Even people don’t notice, they are negotiating about everything in normal life. When the word negotiate comes up, people think about companies and job interviews but actually, every debate, discussion, decision are negotiating processes. For example; even though you want to go somewhere with your friend, you are negotiating with him/her while trying to find out where you will end up going. So negotiating is a key of our lives. But we can make it easier with creating agents and making them negotiate with human counterpart in behalf of us. There is a lack of quality negotiation tools. Genius can create domains and issues. You can also negotiate within the program but there is no interactive avatar that users will get better results like they are talking to person. On the other hand, IAGO has avatar system but it does not have a good agent system. So, our negotiation tool is needed in this market. Based on these facts stated above; we started this project to create a better negotiation tool that will give satisfying results and work efficiently with interactive avatar. We picked this project topic from Reyhan Aydoğan who is a faculty member of Ozyegin University. 
      Human Agent Negotiation Research Tool is a desktop application tool which helps people to operate negotiation sessions with our unique agent with the help of our domain system which is useful to edit the data. Users will be able to create domains and issues with their specific values. Furthermore, users will be able to choose a selected domain and start negotiating within the negotiation page. Also users will be able to choose whether they will use male avatar or female avatar as well. We are using javax swing utilities in order to create the opening pages and negotiating pages. We faced some several problems like keeping the repository paths in our data and how to reach them. We solved them with saving paths to a main xml file and we reached to these paths using document builder factory and JAXB. 
    Most of the problems we faced were about the negotiating strategies. In the beginning, we were planning to combine several strategies in one solid strategy. But after we discussed with our supervisor, we decided to use them seperately and collect data from real users. Deciding which tactics we will use was difficult. We have choosen the most compatible ones with our tool. Designing how agent will react was also a problem and also giving emotions to our agent and making it different with the male and female avatar was one of the serious problems as well.

Assumptions:
         There are some specific assumptions we made for Human Agent Negotiation Research Tool.
●	We assume that Negotiation Community will be interested in our tool and use it in their research.
●	We assume that our desktop application might be developed as mobile applications for IOS and Android operating systems.
●	We assume that in the future users will not have to type or choose their preferences while negotiating; there will be a facial recognition system that will understand the emotions and answers of the human counterpart.
●	We assume that the worldwide companies will be interested in our tool and they will use it in order to make interviews, discussions and auctions.
●	We assume that in the future there will be a better toolkit than Java Swing for GUI development. 
Constraints:
       There are several constraints for our final project. For the project; we will present our tool on 18.05.2018.Because it is the deadline for presenting our project in the second semester. For the negotiation tool: First of all; in order to run the application, user needs a computer to use the program. Second one is; if all the domains are removed, users need to create the domains, issues and preference profiles to do negotiation sessions.

    Functional Requirements:
             Functional Requirement 1:
●	ID: HANRT-001
●	Title: Window Selection
●	Description: In the opening page, user should be able to choose to continue with whether running a negotiation session or domain eliciation.
             Functional Requirement 2:
●	ID: HANRT-002
●	Title: Opening Domain System GUI
●	Description: If user selects domain system in window selection page, the application should send the user to domain elicitation GUI.
             Functional Requirement 3:
●	ID: HANRT-003
●	Title: Create agentOffer with Previous Domain Data
●	Description: When the domain system GUI runs, the tool should create a J Tree and fill it with the previous domains.
             Functional Requirement 4:
●	ID: HANRT-004
●	Title: Receiving Data From Repository
●	Description: System should reach the paths of previous domains which are created by users from “repository.xml” file.
             Functional Requirement 5:
●	ID: HANRT-005
●	Title: Reading Paths and Reaching Domain Files
●	Description: After reaching the paths from repository, system should also reach to the domain files and take the data.
             Functional Requirement 6:
●	ID: HANRT-006
●	Title: Adding Selection Model to J Tree
●	Description: System should show the information panel for each JTree node.         
             Functional Requirement 7:
●	ID: HANRT-007
●	Title: Creating J Table for Domain Information
●	Description: System should create a J Table with domain data in information panel when user clicks to a specific domain from J Tree.
             Functional Requirement 8:
●	ID: HANRT-008
●	Title: Adding Previous Issue Data to J Table
●	Description: User should be able to see previous added issues and their values when the domain information panel is opened.
             Functional Requirement 9:
●	ID: HANRT-009
●	Title: Removing Issue
●	Description: User should be able to remove an issue.
             Functional Requirement 10:
●	ID: HANRT-010
●	Title: Save Domain Changes
●	Description: User should be able to save data of domain after editing by clicking “Save Changes” button.
              Functional Requirement 11:
●	ID: HANRT-011
●	Title: Create Preference Profile
●	Description: User should be able to create and edit preferences of a domain by clicking “Preference Profile” button.
             Functional Requirement 12:
●	ID: HANRT-012
●	Title: Save Preference Profile
●	Description: User should be able to save preferences of a domain by clicking “Save Preferences” button in preference page.
             Functional Requirement 13:
●	ID: HANRT-013
●	Title: Creating New Domain
●	Description: User should be able to click “New Domain” button and give a proper name to create a new domain. Also that domain should be added to J Tree immediately.
		 Functional Requirement 14:
●	ID: HANRT-014
●	Title: Adding New Issue
●	Description: User should be able to click the “Add Issue” button and enter the issue name and values and add the new issue.
             Functional Requirement 15:
●	ID: HANRT-015
●	Title: Choosing Issue Property
●	Description: User should be able to choose issue property whether it is a discrete value or an integer value while adding a new issue.
             Functional Requirement 16:
●	ID: HANRT-016
●	Title: Saving Files To Both Repository and Domain Files
●	Description: System should create a new domain xml file while creating a new domain. Also system should save the path of this file to the repository file.
             Functional Requirement 17:
●	ID: HANRT-017
●	Title: Opening Domain Selector GUI
●	Description: User should be able to see the domain selector GUI after clicking negotiation session in the first page. In the new page, user should be able to choose a domain to negotiate.
              Functional Requirement 18:
●	ID: HANRT-018
●	Title: Choosing Avatar Gender
●	Description: User should be able to decide whether they will do the negotiation with female or male avatar on Domain Selector GUI.
             Functional Requirement 19:
●	ID: HANRT-019
●	Title: Starting Negotiation Session
●	Description: User should be able to view the negotiation page after choosing a unique domain. 
             Functional Requirement 20:
●	ID: HANRT-020
●	Title: Terminate The Negotiation
●	Description: User should be able to terminate the negotiation and finish without getting a result.
             Functional Requirement 21:
●	ID: HANRT-021
●	Title: Accepting The Offer
●	Description: User should be able to accept the offer made by the negotiation agent.
             Functional Requirement 22:
●	ID: HANRT-022
●	Title: Giving Offers
●	Description: User should be able to give offers from limited choices.
             Functional Requirement 23:
●	ID: HANRT-023
●	Title: Viewing The Events in Negotiation Window
●	Description: User should be able to view the events throughout the negotiation.
             Functional Requirement 24:
●	ID: HANRT-024
●	Title: Viewing Interactive Data
●	Description: User should be able to see the Avatar while negotiating.
             Functional Requirement 25:
●	ID: HANRT-025
●	Title: Using Emojis to Express Feelings
●	Description: User should be able to give reaction to agent by clicking happy, angry and shocked emojis.
Non-Functional Requirements:
               Non-Functional Requirement 1:
●	ID: HANRTN-001
●	Title: Negotiation Termination Time
●	Description: Negotiation should end in 180 seconds.
               Non-Functional Requirement 2:
●	ID: HANRTN-002
●	Title: Domain and Preference Profile Need for Negotiation
●	Description: There should be an existing domain and preference profile to start the negotiation.
               Non-Functional Requirement 3:
●	ID: HANRTN-003
●	Title: Domain Privacy
●	Description: Domain information should be protected for privacy of domains.
               Non-Functional Requirement 4:
●	ID: HANRTN-004
●	Title: Domain Capacity
●	Description: The system should have capacity to add new domains.

IV.	Solution Approach

Design Decisions:
            Frankly, this is a tool that enables users to get in touch with a negotiation agent which users can bargain with it. This tool is needed because of the lacking parts of current tools at the market such as: “Genius, IAGO”.  The user interface part of the negotiation section can be seen in Figure 9.


 
                                                       Figure 9: Negotiation Page with Male Avatar

	Our project includes MVC pattern and focuses on Object Oriented Programming paradigm which has advantages. The combination of the avatar with negotiation agent reveals out and very efficient and beneficial time consummation for both companies that use this tool or the user who negotiates with our agent. The development of the agent part takes long time comparing to other parts. 
           
       For the MVC part, we have our own model, view and controller parts. We designed several different classes with their constructors such as repository, domain and issue classes. Every one of them has their own XML elements, in order to save the data to xml files with the help of JAXB. Domain is connected with issue class. We created an array list which holds the issues in a specific domain. The same system  works between repository and domain since repository holds all the domain data.  


Agent & Actions:
      Development of agent took the most time. We have 3 kinds of actions in our system: Offer, Accept and End. Since user is starting the negotiation, agent takes the action and evaluates its own action and sends it to human counterpart. Agent reacts differently for every incoming action. You can find the basic system of agent action evaluation below.
 
 
 Negotiation Strategies:
        Agent has 3 disparate strategies which we can change before the session starts. These strategies are Time Based, Emoji Based and Behaviour Based.
Pseudo code for Time Based Utility Modeling:
If timer is greater than or equal to 120
    agentOfferUtility > issueSize * hardOfferLimit
else if timer is less than 120 and greater or equal to 60
    agentOfferUtility > humanOfferUtility + (issueSize * offerLimit)
else if timer is less than 60
    humanOfferUtility < agentOfferUtility < humanOfferUtility + ( issueSize * offerLimit)
Pseudo code for Emoji Based Utility Modeling:
if in happy mood
    humanOfferUtility < agentOfferUtility < humanOfferUtility + (issueSize * emojiLimit)
else if in angry mood
    agentOfferUtility > humanOfferUtility + (issueSize * emojiLimit)
if in shock mood
    humanOfferUtility < agentOfferUtility < humanOfferUtility + (issueSize * emojiLimit)
Pseudo code for Behaviour Based Utility Modeling:
if humanOfferUtility is greater than prevHumanOfferUtility
    agentOfferUtility should be greater than prevAgentOfferUtility
else if humanOfferUtility is less than prevHumanOfferUtility
    agentOfferUtility should be less than prevAgentOfferUtility
Pseudo code for Acceptance Strategy:
if humanOfferUtility is greater than multiplication of issueSize and acceptLimit 
    Accept Offer
else
    Evaluate Offer
*In every minute, acceptLimit is decreasing*
          Time Based strategy uses a tactic which is; agent reacts according to time. In the very beginning agent makes a hard negotiation and strict with its demands. Yet, when time passes, agent starts to find a common good way for both sides.
       Emoji Based Strategy uses emojis as an important factor. When user gives impressions via emojis, agents reaction changes according to the type of the emoji. We have happy, angry and shocked emojis in order to use. Happy emoji makes agent softer. Angry emoji makes agent competitive and finally shocked emoji makes agent more negotiable.
       Last but not least, maybe the hardest strategy we have is Behaviour Based Strategy. Agent reacts according to users actions. If user is a negotiable person and understands what the opponent wants, then agent is also negotiable. If user reacts aggressive and keeps doing hard negotiation, then our agent will react the same also. So this makes users confuse a lot to negotiate with our agent.

Negotiation Protocol:
      Our negotiation sessions take place between human and agent counterpart. After the session begins; user starts the negotiation by giving the first offer. Agent takes humans offer and evaluates on its own. Then returns a counter offer. After agents response user can accept the offer, end the negotiation session or give another counter offer to make demands. Agent takes humans counter offer and checks the preference weight for itself. If it is a good offer, then agent can accept the offer. Otherwise agent evaluates the offer and reacts visually. These reactions are sad, happy and shocked. If agent is close to accepting, then agent is shocked. If agent does not like the offer, then agent reacts sadly. Also agent has sound effects, in order to make it as a real negotiation, we added sounds to avatar for both genders. Agent and user can talk basicly. Furthermore, if the human offer’s weight is less than an expected value, then agent keeps giving counter offers which are randomly generated in order to get the best result. 

     You can see the negotiation protocol schema below:
 
          Utility of an offer is calculated according to the preference weights of the issue values from the preference profiles. Every value has its unique weight for both human and agent. Both of them gives offers in order to these preferences. They don’t know each other’s preferences. They react according to themselves.
           Also the session takes 180 seconds which is 3 minutes exactly. If the negotiation won’t finish until the timer ends, then the negotiation session will be terminated. In this case, both sides will get 0 preference weight.
           Agent’s strategy is to take the offer from human part and make a decision whether giving a counter offer or accepting the offer. Agent evaluates the offers according to the preference values of itself. 
              You can see our Activity Diagram below:
 
     
      When the tool is started, it gives user 2 options; domain operator and negotiation session. You can see it in the appendix part, Figure 1. Domain operator lets user to manage the domains and issues which can be seen in the Figure 2. The operator has its own page. User will be able to click any domain to display domain’s own page (Figure 4) or create a completely new domain (Figure 3). From the domain page, user is available to edit the issues like adding or removing an issue or save the latest changes. If user clicks the save button: System saves 1 new xml file (Figure 6) and adds this new files path to our existing repository xml file (Figure 7). Also user is able to add issues from domain page. When user clicks to add issue button; a new panel comes and the user edits the new issue values. User decides whether it be a discrete value or an integer value (Figure 5). After adding new issue, the domain page will be repainted and it will add the new issue to the J Table.
        If user clicks the negotiation session in the beginning, domain selector page comes up which you can see in the figure 8 from appendix. Afterwards, user selects the domain and starts the negotiation session. Negotiation page can be seen in the figure 9. System takes the domain data and issue data and allows users to make offers and counter offers in this specific page. After agent gives an offer, user has the chance to terminate the negotiation or accept the incoming offer and finish the negotiation.

Tools and Techniques We Used:
        We used object-oriented programming within Java Language in Eclipse program. It was a language we were familiar from the very first year of our university life. We were working with object oriented programming. We used the class hierarchies and created the constructors in order to create a new object. We created our tool according to the MVC system. We had all the model classes which we have designed the variables that we will also hold in our xml files.
         We needed to save every domain and issue data; because we would be using these data to negotiate with the agent. To do so; we used the JAXB framework to marshall and unmarshall the xml files. You can see the code examples in Figure 11. First we take the data of domains and issues and when the user clicks the save button, system creates an xml file for the domain file under the “XML files” folder. By marshalling, we fill the xml files with the data we took. By unmarshalling, we reach an already existing file and take the data inside from that xml file. We used these techniques to save the data and also to reach the data while negotiating. When user selects negotiation session, user will see a new page and select a domain to negotiate. After that the negotiation will start. 
         Also we used JAXB and class hierarchy in order to create preference profiles. When user clicks preference profile when checking a domain via domain operator, user can change the preferences from that page. Also user can save the changes as a different preference XML under the file “Preferences”. You can see one of our preference xml example in figure 99.
        We used java swing materials to design the pages. We had the biggest helps from J Tree and J Table functions. In J Tree we are holding the domains and issues. In J Table we are showing the issues in the chosen domain. These pages are interactive, so it reacts to the changes user made. It is really easy to use so everyone can understand the basics of usage. 
  Courses:
●	CS 102 [Object Oriented Programming]: This course was one of the first computer science courses we took. We learnt the basics of how to code in Java language and object oriented programming.
●	CS 201 [Data Structures and Algorithms]: This course was really important because we learnt the algorithm systems and data structures. While trying to hold the data, we used the basics from this course.
●	CS 222 [Programming Studio]: In this course we learnt how to write clean code. With the usage of clean code, it is easy to understand the code. It becomes more organized and meaningful. We wrote our code with clean code also.
●	CS 320 [Software Engineering]:  We gained the software engineering skills in this course. Bu the most important part was to learn how to write an academic report. We are using the basics to write final project report.
●	CS 321 [Programming Languages]: In this course, we learned how a programming language exists and reacts to events. In our project we used the ideas we get from this course in order to find the best results of coding.
    
   Engineering Standards:
●	Data Format: XML(Extensible Markup Language)
●	DOM: Document Object Model
●	OBJ: Object Orientation
●	ENV: Runtime Environment



















V.	Results and Discussion

    	We finished our application by developing the full version of our negotiation tool by adding two avatar options, sound and 3D features and also the agent is compacted with three strategies. We did an experiment with 3 groups of 12 person at each strategy. 

  We designed eye-pleasing GUI structure for our project. Users are able to operate the events such as creating domains and editing issues. Also users can create their preference profiles. On the other hand, we designed an agent. We developed 3 different strategies with different negotiation tactics. We added emotions to our agent avatar. Agent can give facial impressions and also it can speak in occasions such as if agent like the offer or does not like the human’s offer.

        In the backend, domain creating systems are working successful. Also every data is being hold in xml files. We are keeping every domain file in our data as well. To read and reach the data we are using JAXB and Document Builder Factory. You can find the document builder code examples in the appendix part, Figure 10. Also Negotiation page takes the domain data and offers a negotiation experience. You can see the implementations and figures under the Appendix headline. As a result, we have our negotiation tool which is capable of managing domains and handling the fast negotiation sessions with human counterpart.  

        In visual side of our project which we have done so far:
●	Welcome page which lets users to choose whether if they want to continue with negotiation session or domain system.
●	Main page of domain system which includes creating new domain feature.
●	Create domain page which lets user to enter the new domain’s name.
●	J Tree that holds the domain data in the left side of the main domain system page.
●	Unique panels for each domain to show the issues and values of the chosen domain in J Table which can be seen when the user clicks the specific domain on the J Tree.
●	Editing system that allows users to add or remove issues in domain panels.
●	Creating and editing preference profile system from domain page.
●	Saving system which is saving the domain file itself and saving the domain files path inside repository file.
●	Saving system for preference profiles to associated xml files of every domain.
●	Add issue page that user can choose either issue values will be discrete or integer.
●	Domain selector page which is being shown if the user clicks negotiation session in the welcome page. In this page, users are able to choose a domain to negotiate.
●	Gender selection on domain selector page which users decide which gender that they will negotiate.
●	Negotiation page which opens when user selects a specific domain in domain selector page and clicks the “Start Negotiation” button.
●	Negotiation page holds 4 separate panels which have different functions. Such as:
✓	Issue selection panel which users are able to choose the issue values from a combo boxes to make an offer.
✓	Avatar panel which holds the avatar which will face with human counterpart. Users can choose whether the avatar will be a male or female. 
✓	Decision panel which users can decide to terminate the negotiation or accept the offer which is made by the agent.
✓	Negotiation window panel which shows the events happened while the negotiation.
     
        To sum up, we created the domain system and the negotiation system. In backend, we are holding the data in order to use while negotiating. We used java language on Eclipse. We used MVC design with object oriented programming. 
         We had a limitation challenge within the negotiation session. It takes responding time limit in order to continue the negotiation session.
         For validation process of our project; we tested our system by adding as much domains as we can to see if the tool can handle such situations like that. We also tested our negotiating system with real people to examine how human counterpart reacts to negotiation agents. With these validation processes, we checked out our functional and non-functional requirements with real people.
          We conduct a user experiment in which 36 number of participants used our tool and negotiate with the bot agents. We tested with 3 different groups for our 3 strategies for Travel Domain.

	In total, 36 person participated and negotiated with agents. Out of 36, 12 human participated in Time Based Strategy and 7 human participants accept our agent’s offer while 5 human participants convinced our agent to accept their offers. User’s average utility is 1,95 whereas agents average is 2,5. The maximum score that a user could get is 3,1 while it is 3,8 for agent. As it is shown below it is a fair game for both sides . 

 
 
In Emoji Based Strategy; 11 users accepted the agents offer and agent accepted users offer 1 time. User’s average preference weight is 2,18 whereas agents average is 2,3. 

  In Behaviour Based Strategy; 7 users accepted the agents offer and agent accepted users offer 3 times. 2 times negotiation time finished before making any agreement. User’s average preference weight is 1,69 whereas agents average is 2,07. It is observed that the participants gained higher utility when our agent employs Emoji based Strategy. The maximum utility taken by user  is 2.7 between all three strategie techniques.


 


		Questionnaire:
		

 

                        61.5 percent of participants say this agent’s reaction made me concede more.
 

                            73.1 percent of participants say this agent negotiated like human negotiator.



 

                            77 percent of participants say this agent negotiates in a fair way.












VI.	Related Work

There are three related tools that looks technically similar to our project. They all have some similarity and discrepancy versus our Human Negotiation Research Tool project. These tools features are listed below:

The first tool which is similar to our program is “Genius”. Unlike our tool, Genius has no avatar that user can negotiate more efficiently and time costly. On the other hand, the Negotiation part of the GUI at this tool has many lacking sections comparing to our negotiation tool. Besides, it does not have any agent that can negotiate with customer, user etc.

The second tool which name is “IAGO” has missing sides in compare to our tool. Moreover,  creating domain and issue section of this tool is not enough to handle the same performance as our tool. However, unlike “Genius” it has an avatar that user can negotiate with it.

In conclusion, our tool is like the combination of these tools which offers much more efficiency and time management rather than others. One of our tool’s advantage is our domain system is better than other tools while getting the domain names and issues. Our second advantage is we have an agent that can negotiate with human counterpart within four minutes, user could terminate the negotiation within this time.  

















VII.	Conclusion

     In conclusion, we created a negotiation tool which includes an avatar that user could face with. We created an agent that can take offers from the user and give a decision according to this offer. Our agent has 3 different negotiation strategies which are time based negotiation, emoji based negotiation and behaviour based negotiation. We tested with 36 participants. Each strategy is tested by 12 different person. According to the results, our agent is a negotiable and understandable negotiation agent.
    Effects:
a.	Economics:  Human negotiation tool will balance the economies of both companies who are negotiating. Because it will consider the greater good for both side.
b.	Sustainability: This tool will work efficiently and it will always make successful negotiations.
c.	Security: Human negotiation tool will not share the details of the negotiations for the beneficence for both negotiation sides. Negotiations will happen in a secure environment.
d.	Ethical Issues: While making this project, we will use our own codes and we will not cheat by using others work. Also it will not show favor to one negotiator. This negotiation tool will be fair to both negotiators.
e.	Environmental Impacts: It will facilitate the negotiations and this will create a healthy environment for companies in several ways.
f.	Manufacturability: More people will able to continue this project from where we started. Tool can be developed by others.
g.	Health: n/a
h.	Social and political issues: n/a

 
Acknowledgements

        

          We would like to thank and give our best regards to our supervisor Associate Reyhan Aydoğan for her outstanding support and guidance.
 
References

[1] Genius. 2018. Genius. [ONLINE] Available at:
 http://ii.tudelft.nl/genius/. 
[2] IAGO Platform. 2018. IAGO Platform. [ONLINE] Available at: 
http://people.ict.usc.edu/~mell/IAGO/. 
[3]Java Architecture for XML Binding (JAXB). 2018. Java Architecture for XML Binding (JAXB). [ONLINE] Available at: 
http://www.oracle.com/technetwork/articles/javase/index-140168.html. 
[4] Document Builder Factory. Available at:
https://docs.oracle.com/javase/7/docs/api/javax/xml/parsers/DocumentBuilderFactory.html
[5] Can Automated Agents Proficiently Negotiate With Humans?  By Raz Lin, Sarit Kraus.
Available at:
https://cacm.acm.org/magazines/2010/1/55746-can-automated-agents-proficiently-negotiate-with-humans/fulltext
[6] Grumpy and Pinocchio: Answering Human Agent Negotiation Questions Through Realistic Agent Design. Available at:
http://people.ict.usc.edu/~mell/publications/iago_4agent.pdf




 
Appendix

In this chapter, detailed description such as codes, data, screenshots, maps, figures and tables, may be represented. 




 
Figure 1: Window Selector Page



After Choosing Domain Operator:
 
Figure 2: Domain Operator Main Page

 
                                                                Figure 3: Adding New Domain
 
Figure 4: Travel Domain Page

 
Figure 5: Add Issue Page


 
Figure 6: XML Data File of Teams Domain
 

Figure 7: Repository XML File (It changes the path for every user)


           
              After Choosing Negotiation Session:

 
Figure 8: Domain Selector Page

 
Figure 9: Negotiation Page with Female Avatar



       
                                                     Figure 12 : Preference Creator Page 

 

                                              Figure 13 : Travel Domain Preference Profile XML
Reaching Data Codes:
 
Figure 10: Getting the path and domain name to build system via Domain Builder Factory
 
Figure 11: Reaching the data via JAXB 
 
