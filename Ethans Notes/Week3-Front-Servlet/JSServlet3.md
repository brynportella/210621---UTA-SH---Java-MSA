# Dom Manipulation

You can manipulate elements in the dom with Javascript

You can use `document.createElement()` to create an element and insert it into the dom tree

You can use `element.replaceChild()` to remove an element from the DOM and replace with another

You can completely remove an element with `element.removeChild()`

Insert a node before another with `element.insertBefore()`

You can set the text of an element `element.innerText`, `element.textContent`

You can set the HTML of an element with `element.innerHTML`

You can clone an element with `element.clone()`

You can use these methods to manage attributes of html elements:

-   `element.getAttribute("attname")`
-   `element.setAttribute("attname")`
-   `element.removeAttribute("attname")`
-   `element.hasAttribute("attname")`

# Events and Listeners

Events occur when a user interacts with a webpage, or when the browser triggers one

You can configure your webpage to handle these events with JS using an event handler, events you can handle include these

-   **onclick** - This is a click event occurs when a user clicks the element on a web page.

-   **ondblclick** - This is a click event occurs when a user double clicks the element on a web page.

-   **onload** - This is a load event occurs when the browser has finished loading the page.

-   **onunload** - This is a load event occurs when a user closes the document.

-   **onresize** - This is a load event occurs when the browser window is minimized or maximized.

-   **onmouseover** - This is a mouse event occurs when the user moves the mouse over an HTML element.

-   **onmouseout** - This is a mouse event occurs when the user moves the mouse away from an HTML element.

-   **onkeydown** - This is a keyboard event occurs when the user presses down a key on the keyboard.

-   **onkeyup** - This is a keyboard event occurs when the user releases a key on the keyboard.

-   **onfocus** - This is a form-input event occurs when the user gives focus to an element on a web page.

-   **onblur** - This is a form-input event occurs when the user takes the focus away from a form element or a window.

-   **onchange** - This is a form-input event that occurs when a user changes the value of a form element.

-   **onsubmit** - This is a form-input event that occurs when the user submits a form on a web page.

There are three ways you can register to handle an event

1. Inline, where you set the on... attribute of the html element to a predefined function in your js file
2. You can set the event property of the html element to a predefined function in js
3. You can use the `element.addEventListener(event, funtion, useCapture)` method

# The Event Object

In JS events are represented by an Event Object

Event objects have the following properties and methods:

-   bubbles: a boolean value which indicates the propagation method, true default
-   currentTarget: a reference to element that triggered the event
-   preventDefault() cancels the event/prevents the default action
-   stopPropagation(): stops the event from propagating
-   target: a reference to the DOM element that triggered the event
-   timeStamp: the time of the event in mili
-   type: type of the event

## Types of Events

There are several subclasses of the event object, which all include their own properties

-   A complete list of event object types: https://www.w3schools.com/jsref/obj_events.asp

### MouseEvent

This is an event that is generated when the user interacts with elements on the page with their mouse

-   Events like click, onmouseenter, onmouseleave, and others create mouse events

The MouseEvent object has several properties that are specific to mouse events:

-   Coordinates of the mouse relative to the window: clientX and clientY
-   Coordinates of the mouse relative to the last event: movementX and movementY
-   Coordinates of the mouse relative to the target element: offsetX and offsetY
-   Coordinates of the mouse relative to the the screen: screenX and screenY
-   Whether alt, ctrl, or shift were hit during the event: altKey, ctrlKey, and shiftKey
-   Which mouse button was hit: button, buttons and which

### KeyboardEvent

This is an event that is generated when the user interacts with elements on the page with the keyboard

You would typically use this to add extra functionality to webforms

-   Events such as onkeydown, onkeypress, and on keyup

The KeyboardEvent object has many properties including:

-   Whether alt, ctrl, or shift was hit during the event: altKey, ctrlKey, and shiftKey
-   Which key was hit: key, keycode, and which
-   Whether the key is being held down: repeat

# Bubbling/Capturing

Javascript has something called event propagation, which is essentially how the event flows through the components on the page

## Event Bubbling

Bubbling is the default event propagation for event listeners

-   Follow a buttom up approach
-   The event starts at the target element, then "bubbles" its way up the DOM tree

Bubbling works for all handlers, regardless of how they are registered with the addEventListener

## Event Capturing

Event capturing is the opposite of bubbling, instead of going from the target to the top of the tree, it starts at the root, and makes its way down to the target element

-   Follows a top down approach

Capturing only works with event handlers that are registered with .addEventListener with the added third argument that is set to true

# JSON

JavaScript Object Notation

-   An easy to read for humans and machines, lightweight, data-interchange format
-   A set of key and value pairs enclosed in curly braces
    -   The key is string
    -   The value can be anything

JSON is useful for:

-   Transmitting data between a server and web application
-   Transmitting serialized structured data
-   Performing asynchronous data calls without needing to refresh the page
-   Restful API's

# AJAX

Asynchronous Javascript and XML

-   The process of exchanging data from a web server asynchronously with the help of XML, HTML, CSS, and JS
-   We use it to load data from a server, and selectively update some part of our webpage without reloading
-   Uses the browsers built-in XMLHttpRequest (XHR) object to send and recieve data from webservers asynchronously

The AJAX workflow

1. A client event occurs on the page
2. JS creates our XHR object
3. The XHR object makes a call to the server
4. The server processes that call/request
5. The server creates a response, and send the data back
6. We process the data in the response
7. We update the page with JS

To send send request you must:

-   Create a XMLHttpRequest object with `new XMLHttpRequest()`
-   Use the `.open(method, url, async)` this will open the connection to the server
-   Use the `.send()` to actually send the request

The server then sends back a response which we can process, this is returned in the form of:

-   responseText: the response as a string
-   responseXML: the response as XML
-   status: the status code for the response
-   statusText: text representation of the status code

Since the data is not retrieved instantly, we must wait for it to be returned. We use the XHR's property readyState, and the function onreadystatechange to observe when the response is ready

The readyState property has 5 states:

-   0 not initialized
-   1 connection established
-   2 request recieved by server
-   3 server processing request
-   4 request finished, response ready

You can set the function onreadystatechange to a custom function to handle the response when it is ready

# Working with JSON in AJAX

The XHR object can only send text data, however we can send JSON by serializing it with JSON.stringify()

To get JSON from a response body, we want to use JSON.parse(), which will take a text object, and convert it into JSON

# async and promises

Asynchrounisity means your program does not need to wait for a specific task that takes a long time to complete, it simply starts executing that task, and move to the next task, while the first one finished

This is useful for API calls, and other processes that could hold up, or "block" the execution of your programs main thread

## How Asynchronous JS work

Javascript like many programming languages implements a stack where function calls are stored

Since JS is single threaded function calls are added to the stack one at a time, and executed one at a time

However, JS also has a built in queue, and the browser/node runtime environment has extra threads that js can make use of

## Javascript Event Loop

When there is a call to an async function, such as setTimeout, setInterval, AJAX requests, fetch requests, javascript can allow the browser/thread web api to handle these specific functions, while the call stack moves on

Once the Web API (aka the thread in the browser) is done processing the function, it will return the callback or response to the queue where it will wait for the call stacik to be empty, then the event loop will return the response/callback to the stack

![Event Loop](gif14.1.gif)

https://blog.bitsrc.io/understanding-asynchronous-javascript-the-event-loop-74cd408419ff

If Javascript is returning from the async function call before it has returned anything, how does JS handle this lack of data?

With promises!

# Promises

Javascript uses promises with async operations, they are placeholders for a future value. Many async function return these promises implicity

-   These are simply a "promise" that the funtion will return some data
-   Promises in JS are objects, and you can create them with the new keyword
-   Promises take a callback function, this is called **executor** which automatically runs when the object is created
-   The executor takes in two callback functions, resolve and reject
    -   `resolve(value)` returns the result of the job once it has successfully completed
    -   `reject(error)` will be called if there is an error with processing the job

Promises have a property of `.status` which gives us information about the state of the object

-   pending
-   fulfilled
-   rejected

The promise object uses consumer functions, which chain funtion calls together

-   `.then` once the promise is fullfilled
-   `.catch` to catch an error
-   `.finally` to run no matter what

# fetch

Fetch is a more modern and veratile way of making AJAX requests

The Fetch API is provided in the window object, and provides the `.fetch()` method

-   `.fetch()` is used to send request and returns a promise that is retrieved from the response
-   If the request is successful the promise will be resolved, and you will be returned the object in the Response Body
-   If the request fails, or returns a HTTP status code indicating an error (400's or 500's) the promise will be rejected

There are various methods you can use to access the response body:

-   `response.text()` read the reponse and return as text
-   `response.json()` read the response and return as JSON
-   `response.formData()` return the reponse as form data
-   `response.blob()` returns the response as binary data with type
-   `reponse.arrayBuffer()` returns the response as an ArrayBuffer

# async/await keywrods

Javascript introduced a nicer way to implement asynchronous functionality in es2017/es8 using the async and await keywords

The `async` keyword denotes that a function will operate asynchronously via the event loop

-   Any function with the async keyword will implicitly return a promise object
-   You can use any of the consumer functions on the return of an async function, however, there is a nicer way to handle these promises

The `await` keywors only work inside of async function

-   await tells javascript to wait for a promise to be resolved before moving on
-   You can use await when calling any function that returns a promise, but it must be inside of an async function
-   It allows you to gather data, or wait for something while also not blocking the main thread

You no longer need to chain consumer functions, making your code easier to read

# Client Server Architecture

A client-server arch is a networking model in which the server provides services to clients to perform user based tasks

Server: is a server software designed to process request and deliver responses to another computer over the internet

Client: is a program that runs locally, and makes requests to a server

![client server](https://upload.wikimedia.org/wikipedia/commons/thumb/c/c9/Client-server-model.svg/1200px-Client-server-model.svg.png)

A client and server established a connection over the internet using a set rules called protocols

There are different protocols for different purposes, we will be using HTTP

-   Clients send HTTP requests to the server, in the form of XML or JSON
-   Server sends HTTP responses to the client

Types of Client-Server Arch

-   2-tier: Simple client to server interface
-   3-tier: Client establishes a connection to a middleware, then the middleware connects to the server
-   n-tier: multiple layers between the client and server

# Servlets

A servlet is a Java class that takes incoming requests, processes them, and generates a response to send back to the user

How servlets work:

![servlet](Servlet.jpg)

# Web/Application Server and the Servlet Container

A webserver is used to handle HTTP requests, where as an Application server is used to handle any type of requests

Application servers pass incoming requests to the application running it, most application servers double as webservers

We will be using Tomcat as our application server

The servlet container is component of some application servers that interacts with the Java servlets

-   They are responsibly for managing the life cycle of servlets
-   Mapping a URL to a specific servlet
-   Ensuring the URL requester has the correct access

The built in servlet container in Tomcat is called Catalin

# Life cycle of a servlet

There are three main methods of the servlet life cycle

-   init()
-   service()
-   destroy()

The steps of the servlet life cycle:

1. Loading of the Servlet
    - When the application server starts up, the servlet container deploys and loads all of the servlet classes
2. Creating an instance of a servlet
    - Once the servlet classes are loaded, the servlet container creaes a single instance for each servlet class
3. Invoke the init() once
    - Once the servlet classes are instantiated, the init() method is invoked for each instantiated servlet
4. Invoke the service() method for each request received
    - Service determines what type of request was sent from the client (GET, POST, PUT, DELETE), and calls the corresponging method to process the request and create a response
5. Invoke destroy once
    - This will be called at the end of the servlets life

# Servlet API

The servlet API provides the interfaces and classes that are needed to build servlets. You can find these classes and interfaces in two packages:

-   java.servlet package - used by servlet or web containers
-   java.servlet.http package - used for handling http requests

The root of the servlet API is the Servlet interface ->

GenericServlet implements Servlet, ServletConfig, Serializable

HttpServlet extends the GenericServlet class, and implements Serializable, this provides us the ability to process HTTP requests with the overriden doGet(), doPost()...

Your CustomServlet extends HttpServlet to override the default implementation for doGet, doPost, etc, to provide the needed functionality for your servlets

# Deployment Descriptor

Java web applications use a deployment descriptor file to define URL's that map to servlets, and to determine which URL's require authentication

The descriptor file specifies the classes, resources, and configuration and the web service uses them to serve HTTP requests

The descriptor is stored in a file called web.xml, stored in the WEB-INF directory of the project

# Servlet Declarations and Mapping

To Declare the servlet in the `<servlet>`, using `<servlet-name>` and `<servlet-class>` inside of the servlet tag

To map the URL's to the servlet class you use the `<servlet-mapping>` with `<servlet-name>` and `<url-pattern>` inside of the servlet-mapping tag

And these are in the web.xml file

# Response Object

The Servlet API provides a HttpServletResponse interface which extends the ServletResponse to assist in sending responses to the client

This allows you to send responses, with different types of data, including, HTML, XML, JSON, text and others

Simple set the content type with .setContentType() method, and use a printWriter to write back to the client

# HTTP Protocol

HTTP: Hypertext transfer protocol

Requests are made up of Verb, URI, HTTP Version, Request Headers, Request Body

Responses are made up of Response Code, HTTP Version, Response Headers, Response Body

Basic verbs/methods for CRUD: GET, POST, DELETE, PUT

Status Codes:

-   100's: Informational
-   200's: Successful
-   300's: Redirects
-   400's: Client Side Error
-   500's: Server Side Error

# Jackson Library

The Jackson API is used to convert Java object to JSON format, to send in a HTTP request, and to convert http request bodies into Java objects

Use the ObjectMapper.writeValue() to convert a Java object to JSON

Use ObjectMapper.readValue() to convert a JSON object to a Java Object
