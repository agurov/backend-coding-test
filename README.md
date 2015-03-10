Running application
===================

To run on DEV environment
------------------
Prerequisites:
   - Install Java
   - Install Maven
   - Install Node.js (includes npm)
   - Install PostgreSQL (>=9.1)
     Create role and datebase:
```
        > CREATE ROLE codingtest LOGIN UNENCRYPTED PASSWORD 'sql' VALID UNTIL 'infinity';
        > CREATE DATABASE codingtestdb WITH ENCODING='UTF8' OWNER=codingtest CONNECTION LIMIT=-1;
```

1. Execute next commands in console:
```
   > cd <project_root>
   > maven clean package
   > java -jar target/codingtest-1.0-SNAPSHOT.jar server config.yml
```
2. Application is available at: http://localhost:8080

Note: In DEV environment you might want specify '-DdevMode' java property to be able to see frontend changes
      right away. With this property enabled static resources are served from "resources/assets" folder and not
      from classpath.

To run using Vagrant
--------------------
Prerequisites:
   - Install Java
   - Install Maven
   - Install Node.js (includes npm)
   - Install VirtualBox
   - Install Vagrant

1. Execute next commands in console:
```
   > cd <project_root>
   > maven clean package
   > vagrant up
```
2. Application is available at: http://localhost:18080
3. To stop application execute 'vagrant halt'
Note: first run of 'vagrant up' can be time consuming due to download (VM image, Java, Postgres) process


Goal
====
Produce a simple web-app backend to complement the supplied front-end code. Note that the front-end renders nicely in Chrome but has some issues in Firefox. This is deliberate - see the 'Extra Credit' section.

Mandatory Work
--------------
Fork this repository. Starting with the provided HTML, CSS, and JS, create a Java-based REST API that:

1. Saves expenses as entered to a database.
2. Retrieves them for display on the page. 
3. Add a new column to the table displaying the VAT amount for each expense.
4. Alter the README to contain instructions on how to build and run your app.

VAT is the UK’s sales tax. It is 20% of the value of the expense, and is included in the amount entered by the user.

Give our account `alchemytec` access to your fork, and send us an email when you’re done. Feel free to ask questions if anything is unclear, confusing, or just plain missing.

Extra Credit
------------
There are rendering issues in Firefox. See if you can fix them.


Questions
---------
##### What frameworks can I use?
That’s entirely up to you, as long as they’re OSS. We’ll ask you to explain the choices you’ve made.

##### What application servers can I use?
Anyone you like, as long as it’s available OSS. You’ll have to justify your decision. We use dropwizard and Tomcat internally. 

##### What database should I use?
MySQL or PostgreSQL. We use MySQL in-house.

##### What will you be grading me on?
Elegance, robustness, understanding of the technologies you use, tests, security. 

##### Will I have a chance to explain my choices?
Feel free to comment your code, or put explanations in a pull request within the repo. If we proceed to a phone interview, we’ll be asking questions about why you made the choices you made. 

##### Why doesn’t the test include X?
Good question. Feel free to tell us how to make the test better. Or, you know, fork it and improve it!
