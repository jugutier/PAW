PAW
===

Exercices for Web Applications Programming.

#Each git tag is one excersice.

##Guide 1
###Exercise 1

####<u>Personal observations:</u> 
`HelloWorld.java` class should go in `ar.edu.itba.it.paw` as it is easily deduced from the code provided. Whereas Jetty's Start class doesn't provide clues on where should it be placed.


In this point it is very important that we realize that Start class is for running and listening with Jetty, but it's not part of the web application per se. It shouldn't be included in the `.war` file when deployed.  


For that reason we will move it to `src/test/java` because `pom.xml` specifies scope target test, which means it'll take care from now and we'll get the desired result.

####Also: 
When deploying to tomcat (refer to `deploy.sh`) we note that `javax.servlet` dependency isn't really at our disposal, so we add it to `pom.xml`. 

####Warning: there might be a conflict with default java compile version. In my case I had to specify version 1.7 in `pom.xml`.

###Exercise 2

####<u>Personal observations:</u>
Read the assignment in detail <u>just one</u> `servlet`. So for this excersice `Helloworld.class` shouldn't be present. 

Consider `HotelManager.java` singleton for retrieving the Hotel list from memory. <big>The list shouldn't be generated for each get request</big>

####Also:
Consider MVC pattern to build HTML code out of model objects, such as Hotel. It will be easier to replace with jsp when needed.

###Exercise 3

####<u>Personal observations:</u>
For the first time we have 2 `servlets` running at the same time. Take special attention on `web.xml` syntax. All the `<servlet>` tag go first and `<server-mapping>` tag go after.

###Exercise 4

####<u>Personal observations:</u>
On the one hand we need to create a form to submit the comment, on the other hand we need to implement the requested `servlet` and retrieve the information submitted by `POST`.

```
request.getParameter("parameter_name");
```
Will come in handy to get the information from `POST` parameters.
####Also:
once `doPost` is completed `sendRedirect` will be needed to go back programatically.

###Exercise 5

####<u>Personal observations:</u>
Some extra dependencies were added in order to rediret to "login" as homepage. The whole validation for login credentials is done within the `Login` Servlet.

####Also:
There's an extra `error` parameter sent by Query String when login is unsuccesfull. This might not be the best solution, but the username isn't lost. A session is still not created, so one could easily access to the hotel list by typing the URL into the browser.

