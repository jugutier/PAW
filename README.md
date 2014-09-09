PAW
===

Exercices for Web Applications Programming.

#Each git tag is one excersice.

##Guide 1
###Exercise 1

`HelloWorld.java` class should go in `ar.edu.itba.it.paw` as it is easily deduced from the code provided. Whereas Jetty's Start class doesn't provide clues on where should it be placed.


In this point it is very important that we realize that Start class is for running and listening with Jetty, but it's not part of the web application per se. It shouldn't be included in the `.war` file when deployed.  


For that reason we will move it to `src/test/java` because `pom.xml` specifies scope target test, which means it'll take care from now and we'll get the desired result.

####Also: 
When deploying to tomcat (refer to `deploy.sh`) we note that `javax.servlet` dependency isn't really at our disposal, so we add it to `pom.xml`. 

####Warning: there might be a conflict with default java compile version. In my case I had to specify version 1.7 in `pom.xml`.

###Exercise 2

Read the assignment in detail <u>just one</u> `servlet`. So for this excersice `Helloworld.class` shouldn't be present. 

Consider `HotelManager.java` singleton for retrieving the Hotel list from memory. <big>The list shouldn't be generated for each get request</big>

####Also:
Consider MVC pattern to build HTML code out of model objects, such as Hotel. It will be easier to replace with jsp when needed.

###Exercise 3

For the first time we have 2 `servlets` running at the same time. Take special attention on `web.xml` syntax. All the `<servlet>` tag go first and `<server-mapping>` tag go after.

###Exercise 4

On the one hand we need to create a form to submit the comment, on the other hand we need to implement the requested `servlet` and retrieve the information submitted by `POST`.

```
request.getParameter("parameter_name");
```
Will come in handy to get the information from `POST` parameters.
####Also:
once `doPost` is completed `sendRedirect` will be needed to go back programatically.

###Exercise 5

Some extra dependencies were added in order to rediret to "login" as homepage. The whole validation for login credentials is done within the `Login` Servlet.

####Also:
There's an extra `error` parameter sent by Query String when login is unsuccesfull. This might not be the best solution, but the username isn't lost. A session is still not created, so one could easily access to the hotel list by typing the URL into the browser.

###Exercise 6

To persist user information to be used in the comment section, we needed to create a session. Credentials couldn't be stored in memory because instances are unique for the whole server.

Refer to this site for learning how to use a session:
http://www.javamex.com/tutorials/servlets/session_api.shtml

###Exercise 7

A filter is the best way to obtain the proposed alternative. With it whenever a user attempts to manually type an address it will be redirected to the login screen (unless a session has been created, product of a succesfull login).

Refer to this site for learning how to use filters:
http://www.oracle.com/technetwork/java/filters-137243.html

####Also:
Remember to include a fully quallified name to the filter in web.xml.

####Known fact:
Filtering by /* within the `web.xml` provokes an infinite loop from the filter calling to itself when entering to login. The best alternative to fix this is asking within the filter code and if it is `/login` then just forward to the corresponding filter.

###Exercise 8

We just need to invalidate the session when loggin out.

####Known fact:
For some reason `getSession(false)` returns a new (empty) session when it should't (a `null` value would be expected). Workaround: ask for the userInfo instead for the session. 


