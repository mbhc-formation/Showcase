# Showcase

<ul>
  <li>Design</li> : 
  This directory is dedicated to design patterns and best practices in software development. Here, you'll find resources that delve into various design patterns, architectural principles, and coding practices aimed at promoting maintainability, scalability, and reusability in our projects. Explore our collection to discover insights into object-oriented design patterns, architectural styles, and effective coding techniques. Whether you're a seasoned developer looking to refine your design skills or a newcomer eager to learn industry best practices, this folder is your guide to mastering the art of software design and development.
  <li>JPA</li> : 
  This directory contains projects showcasing the implementation of the Java Persistence API (JPA). Explore various projects demonstrating how we access, persist, and manage data between Java objects/classes and a relational database using JPA. Each project offers unique insights into different aspects of JPA, from basic CRUD operations to advanced mapping techniques.
  <li>JSF_Primefaces</li> : 
  Here, you'll find projects centered around JavaServer Faces (JSF) and PrimeFaces frameworks. Delve into our JSF views (XHTML files), managed beans (Java classes), and configuration files to understand how we leverage JSF and PrimeFaces to build dynamic web applications. Whether you're new to JSF or a seasoned developer, these projects offer valuable insights into JSF-based development and PrimeFaces integration.
  <li>Java_Exercices</li> : 
  This is where we house our Java exercises and practice projects. Dive into a collection of code snippets, sample programs, and small projects organized by topics or difficulty levels. Whether you're honing your Java skills or exploring new concepts, these exercises provide hands-on practice and reinforcement of Java programming fundamentals. Join us on a journey of continuous learning and improvement in Java programming.
  <li>Maven</li> : 
  This directory hosts Maven-based projects and related resources. Explore our pom.xml files, Maven profiles, settings files, and other Maven-related configuration or documentation essential for our projects. Whether you're a Maven enthusiast or just getting started with dependency management and project builds, these projects offer valuable insights into Maven usage and best practices for project management and automation.
</ul>


  <b>1 - fizzbuzz-generator</b> : a sample project with an advanced solution for the fizzbuzz problem.
  
  The used solution is more generic because it can replace a number by a custom sequence (if you don't want to use "fizz" and "buzz" words)
  
  <b>There is no main function but you can run the example from the unit tests</b>

*********************************************************************************************************************
  
  <b>2 - java-persistence-showcase</b>
  
  Project for JPA Relations showcase.
  
  <b>Used relations</b> :

  <ul>
    <li>One to one : uni and bi directionnal example</li>
    <li>One to many (and one to one) : uni and bi directionnal example</li>
  </ul>

  In every package, you can find the entities, the repository class and a XXXXMain class to test the given examples.
  
  <b>N.B</b>
  This project is configured to run with H2 in-memory database, for testing purposes (see src/main/resources/persistence.xml)
  
*********************************************************************************************************************
  <b>3 - tell-dont-ask-kata-refacto</b> : a sample project showing refactoring of the tell don't ask kata.
  
  Original kata can be found here : 
  <br>
  Kata : https://kata-log.rocks/tell-dont-ask-kata  
  Original Code : https://github.com/racingDeveloper/tell-dont-ask-kata
    
  <b>There is no main function but you can run the example from the unit tests</b>
