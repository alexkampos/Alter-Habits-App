<!-- # AlterHabits Back End implementation.
Back End implemented using Spring Rest APIs that provided AlterHabits' React App any data needed for the view.
The app also uses JWT Spring Boot for security.
Furthermore in this repository anyone can see the database schema queries. -->

<!-- # AlterHabits React App.
Implementation of the View on AlterHabits web application using React framework.
The application is retrieving any data needed to be rendered through asychronous requests on
Spring Rest APIs on Back End. -->

## Name

Alter Habits

## Description

Alter Habits idea was basically to create an application for people who are bored of the gym or do not want to engage exclusively in any sporting activity but still want to take part on them. They should have the opportunity to pick among various sporting activities (e.g. dance, football, karate...)  without having to only participate to one of them, or have to pay a full subscription to each one of them. Based on that idea Alter Habits provides users with a number of appointments (based on a subscription) available to use in a variety of sports and activities shown in the application. 

The application has been separated into two smaller ones and is based on <a href="https://en.wikipedia.org/wiki/Model%E2%80%93view%E2%80%93controller">MVC</a> software design pattern. The front end application (View) located in <ins>front-end</ins> folder is created using Javascript and specifically ReactJS library. The back end application (Controller) located in <ins>back-end</ins> folder is implemented using the Spring Framework. REST APIs are created providing any data needed, from the View, in JSON format. The data are persisted in a MySQL database (Model). 

### Features

Project's key features include:\
\
&emsp;&#8226;&emsp;Unique user account (based on <a href="https://jwt.io/introduction/">JWT</a> authentication)\
\
&emsp;&#8226;&emsp;Display of Shops on map\
\
&emsp;&#8226;&emsp;Asychronous update of Shops displayed based on Activity filtering\
\
&emsp;&#8226;&emsp;Make an activity appointment\
\
&emsp;&#8226;&emsp;Scheduler keeping track of appointments up to 7 days ahead



