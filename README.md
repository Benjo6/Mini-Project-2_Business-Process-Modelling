# Mini-Project-2_Business-Process-Modelling

## Objectives of this Assignment
The main objective of this task is to help you get familiar with the business context of system integration and to provide practical experience in modelling and automation of business processes by the implementation of standard methods and notation.

**Tasks**

The task is to design a business process and develop a software application workflow, which integrates
and automates several disparate operations.
You can choose between processes related to either

a) organization of marketing campaigns

*b) handling of customer complains*

I selected process B for this assignment

**Requirements**

In this assignment, I have to implement a process with business rules, software services and human tasks. 

## The Application

There are two distinct ways to run the program. The first method uses a server application created using SpringBoot. You can start a process within this service application that gives you tasks to complete in order to complete the process. The second method uses a Javascript console application that queries you briefly before starting the complete procedure. 

**The Process**

My approach to handle customer complains is through a human task where the customer fills out a set of questions to give the best idea of what his issue is to the customer service. 

The questions:

-Name

-Email

-Which type of complain

-Details about the complain

The server will determine if the issue is relevant to the tech team or customer service after the customer has completed this form in the server application (Camunda-server) or responded to the questions in the console application (Javascript).If there is a problem with the website, the IT team will be notified; otherwise, customer support will be contacted.The appropriate team will then receive a message regarding the complaint from the auto mail sender, and the consumer will receive a letter of confirmation from the auto mail sender.Last but not least, the Java project's email list will contain the customer's email. 

![](Customer-Complains/PictureOfTheBPMN.png)
*Picture of the BPMN process for the approach without an external task client*

![](JavascriptTaskClient/PictureOfProcessJS.png)
*Picture of the BPMN process for the approach with an external task client (javascript)*

Due to the console application's inability to send emails (Camunda function) while the process is running, there is a slight variation between the two processes (for some weird reason). Another distinction is that the console application lacks a human task because such a task cannot be carried out independently of the server program. 

### The Methods

<strong>Java Project:</strong>

AddEmailToEmailList = takes the email from the inserted information by the customer and add this email into a file called emailList.

AutoResponseForANewComplain = takes teh email from the inserted information by the customer and sends a confirmation letter to the mail.

MailToTheCustomerService = if the complain type isn't about the site then customer service will receive a mail by the auto mail sender about the user complain.

MailToTheTechTeam = if the complain type is about the site then the tech team will receive a mail by the auto mail sender about the user complain.

<strong>Javascript Project:</strong>

CompleteTask (name,email,body) = in this method it takes the inserted information made by the user and complete the task called what is your complain.

##How to run the program

Completing the process through server:

1. Clone the project

2. Open project Customer-Complains

3. Run the application and go to http://localhost:8080/

4. Go to Task List

5. Tap on the process button and select the Customer-Complains or start the process through the modeler in projects bpmn file.

6. After completing the process check https://www.wpoven.com/tools/free-smtp-server-for-testing and insert AutoResponseMail@RandomMail.com to see if the mails were sent. Also, check the email list within the Java project to see if your mail were inserted into the file.

Completing the process through Javascript console application

1. Clone the project

2. Open both projects

3. Run the Java application to start the server

4. Either start the process through the task list or through the modeler.

5. Run the Javascript application.

6. After completing the process check https://www.wpoven.com/tools/free-smtp-server-for-testing and insert AutoResponseMail@RandomMail.com to see if the mails were sent. Also, check the email list within the Java project to see if your mail were inserted into the file.

