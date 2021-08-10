# AOP and Cross Cutting Concerns

AOP stands for Aspect Oriented Programming, instead of concerning ourselves with objects, we focus on Aspects, which modularize particular concerns which can present across multiple classes, known as cross cutting concerns

Examples:
- Database access
- Data entities
- Error Handling
- Logging

AOP and Cross Cutting Concerns help us reduce code redundancy by transfering repsonisibility of these common problems to aspects

AOP Terminology:

- Aspect: A representation of a concern which cuts across multiple classes
- Weaving: The process of linking aspects with other objects, such beans to create advise. This can be done at compile time (such as when using AspectJ compiler), load time, or runtime. Spring preforms weaving at runtime
- Join Point: A specific moment during the executing of a program, sush as the invocation of method, in which actions can be taken
- Advice: Action taken by an Aspect at a specified Join Point
- PointCut: A definition of which methods in our appliction advice ought to be injected into, or around.
- Introduction: Declaration of new interfaces and corresponding implementations in subclasses of any advice objects. These use the `@DeclareParents` annotation with the defaultImpl attribute to define a default concrete class for the bean definition

# AspectJ

@AspectJ refers to a style of delcaring aspects through the use of regular Java classes with annotations.

@AspectJ style was introducing in the AspectJ 5 release of the Aspect Project.

Note that Spring interprets the same annotations as AspectJ 5, using a library supplied by AspectJ, however Springs AOP runtime is not dependent on the AspectJ compiler or weaver

@AspectJ configuations can be enabled either XML or Java-based Spring configuration. In either case you will need to make sure that AspectJ aspectweaver.jar is on your applications classpath.
(version 1.6.8 or later for Spring version 4.0.x)

# Advice

Like mentioned above, advice is specific actions taken, defined as a method, at a particular point during execution of the program

There are 5 types of advice:

- Before: will execute before a join point, but does not have the capability to halt the normal execution of the proceeding join point (unless an exception is thrown)

- After Returning: will execute after a join point completes without throwing an exeception

- After Throwing: will execute if a join point throws an exception

- After (finally): will execute regardless of how the join point completes, whether normal or throwing an exception

- Around: will execute before and after the join point. Around advice is the most general, but also most powerful. It can perfoem custom behavior before and after method invocation, and can be responisble for choosing wether to proceed to the join point method, or shortcut the advised method by returning its own value or throwing an expection

- In general it is recommending to use the least powerful kind of advise for any particular task. For instance if you only need to update a cache with a value returned from a method, it is best to run the `AfterReturing` advice type

# Pointcuts and Join Points

Pointcuts determine joinpoints, because they are define which methods in our application adivce ought to be injected into or around

Join Points are the specific moment during executing of a program in which the advice can be taken

Pointcuts are comprised of a name, and any parameters, and keep in minf these determine EXACTLY which method invokation we are interested in

To create a pointcut we use the @PointCut annotation with regular method signatures, these include:
- execute
- within
- this
- target
- args
- @target
- @args
- @within
- @annotation

Execution is the most widely used, and you can use patterns with wildcards to specify a joinpoint

```java
execution(modifers-pattern? ret-type-pattern? declaring-type-pattern? name-pattern(param-pattern) throws pattern?)
```