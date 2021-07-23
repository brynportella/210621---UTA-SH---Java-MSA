# Request Dispatcher

The request dispatcher interface defines an object that passes along the clients requests to any other resources on the server

There are two possibilities

-   forward(req, res): passes a request from one servlet to another resource on the server. The contents of the request and response are preserved and forwarded to the next resource which will process the data, and return it to the client
    -   The client will not know it was forwarded, because the url does not change
-   include(req, res): does not entirely transfer control over the request and response object to the next resource, instead this method includes the content of the orginal resource in the response returned to the client

# Redirecting with Response Object

The .sendRedirect(url) method on the HttpServletResponse object allows you to redirect the client to a resource outside of the server

Opposed to te forward method on request dispatcher, which directs the client to a different resource inside of the server

# Servlet Config and Servlet Context

ServletConfig is an object created by the Servlet Container, used to pass initial parameters or configurations to a particular servlet

-   Setup inside of the `<servlet>` tags in the web.xml
-   Use the `<init-param>` and next the `<param-name>` and `<param-value>` inside
-   You can get access to these in your java program by using .getServletConfig() method on the HttpServlet class

SerlvetContext is the object created by the Servlet Container to share initial parameters or configurations to all servlets and other components

-   Use the `<context-param>` tags inside of the webapp tags of the web.xml
-   Inside of the context-param tags you use `<param-name>` and `<param-value>`
-   You can access these parameters by using .getServletContext() method on the HttpServlet class

# Exception and Error Handling

The servlet API allows us to handle exceptions and errors caused during the execution of a servlet, and still send a useful response to the user

You just need to include the `<error-page>` element in your web.xml, this is used to specify the invocation of servlers in response to certain exceptions or http status codes. YTou can use the following inside of error-page

-   `<error-code>`: used to specify the status code
-   `<exception-type>`: used to specify the exception
-   `<location>`: used to specify the location to a resource which is displayed upon an error

Before the servlet container invokes the servlet to handle an exception, it sets some attributes in the request to get useful information about the exception:

-   javax.servlet.error.status_code
-   javax.servlet.error.servlet_name
-   javax.servlet.error.exception
-   javax.servlet.error.request_uri
-   javax.servlet.error.exception_type
-   javax.servlet.error.message

# Session Management

The HTTP protocol is stateless, meaning that it does not store any client information on the server

We can create what we call sessions, and send the session information in every request that the client makes

Session tracking is a mechanism a servlet can use to maintaine the state about a series of requets, and there are serveral ways to do it

-   HttpSession API
-   URL Rewriting
-   Hidden Form Fields
-   Cookies

## HttpSessions API

The servlet API provides the HttpSession interface which provides a way to identify a user and store their information

The servlet can generate unique session id's and given them back to the client, who will send that id with every request going forward

To create a session you simply use the HttpServletRequest objects .getSession() method, and if a session does not exist, it will create one

Other importants to know:

-   **setAttribute(key,object)** - used to bind an object to the session, using the key specified.
-   **getAttribute(String)** - used to retrieve a specific saved object from the session object, using its key.
-   **removeAttribute(key)** - used to remove the object bound with the specified key from the session.
-   **invalidate()** - destorys the session.
-   **getId()** - returns the unique ID assigned to the session.
-   **getCreationTime()**- returns the time when the session was created
-   **getLastAccessedTime()** - returns the last time the client sent a request associated with the session
-   **getMaxInactiveInterval()** - returns the maximum time interval, in seconds.
-   **setMaxInactiveInterval(int interval)** - Specifies the time, in seconds,after servlet container will invalidate the session.

## URL Rewriting

URL Rewriting is a process by which a unique session ID gets appended to each request URL, so the server can identify the user sesssion

URL Rewriting maintains the session and works even when the users browser does not support cookies

## Hidden Form Fields

Hidden fields can be inserted into webpages and used by servlets for session tracking

The fields are not visible directly, but can still be seen in the inspect window, so they should not be used for security

You can use these to send session data thought form data, and the user will never see it

## Cookies

Cookies are key-value pairs of information sent by the server to the client, which the client will store

-   Then you can send the cookie in the HTTP request header

The servlet can check for the presence of the cookie in the header, most likely get session information

There are kinds of cookies:

-   Non-persistant: A cookie that expires when the user closes the browser
-   Persistant: A cookie that will only expire if the user logs out of the website, it is stored even if the web browser is closed

# MVC Design Pattern

Model View Controller Design Pattern, a it is a design pattern that is used to design user interfaces, and the structure of an application

Model: User to represent the business layer if the application. AKA, the data layer which defines the bussiness logic of the system, abd represents the state of the application

View: The presentation layer/ui of the application. It displays the data that is fected from the model by the controller

Controller: Is the link between the View and the model. It receives user requests from the view, and talkes to the model layer, then returns that data back to the view

The advantage of breaking our application up into layers like this is so multiple developers can work on different layers all at the same time

It also enables logical grouping of related actions on a controller together

# Front Controller Design Pattern

The front controller design pattern provides a single handler for all incoming requests for a resource in an application, then dispatches the requests to the appropriate secondary handler for that type of request

It uses a helper API to achieve the dispatching mechanism, it is broken up into four different components:

Front Controller is the single point of entry, it directs the requests to the dispatcher

Dispatcher is responisble for managing the actions and the views, including locating and routing to specific actions that will service a request, and finding the correct view

Helper classes (controllers) are used to break up the logic of specific features, and makes the program easier to build and maintain

Views represent and display information that we want to display to the client

![front-controller](./frontctrller.gif)

# Introduction to REST

Rest: Representational State Transfer

It was originally defined by Roy Fielding in 200 in his dissertion stating:

-   Rest is an architecture style that outlines communication between a client and a server over web

1. Uniform Interface: your URL's to resources should be uniform, and self descriptive
2. Client-Server architecture
3. Stateless: the server should hold no information about the state of the session
4. Cacheable
5. Layered System
6. Code on Demand (Optional)
