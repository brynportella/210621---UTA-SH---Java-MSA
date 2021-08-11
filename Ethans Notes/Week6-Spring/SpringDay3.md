# Spring MVC

Spring MVC is a request driven structure centered around a central servlet using the front controller design pattern

![spring-mvc](mvc.png)

The Spring DispatchServler is completely integrated with the Spring IOC Container

The DispatchServlet routes to handlers, view resolvers, and also provides support for uploading files

Since DispatcherServlet is still a Servlet, we have to map it in the web.xml

View Resolvers will retrievew the correct view from the controller

Spring MVC has several annotations that we use specifically with MVC components

@Controller will mark a class as a controller, which is a special kind of bean that handles requests, the dispatcher will scan for these classes, and send requests to the correct controller

@RequestMapping is used to map a uri to a specific class, or to a specific method inside of a controller, you can also include the http method if it over a method

Other important annotations used inside of the @Controller classes:

- @RequestBody: used to gain access to the request body
- @ResponseStatus: used to mark a specific status code that a controller method should send in a response
- @RequestParam: used to bind request parameters to a specific value in the methods signature
- @PathVarible: used to identify properties defined within the URL of the request, you can use that in the method
- @RequestHeader: used to get or map header data in a simlar way of @RequestParam
- @ResponseBody: used to automatically marshal (convert from a java object to a json) a Java object
- @RestContoller: a class level annotation that combines @RequestMapping and @ResponseBody