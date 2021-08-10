# Spring

Spring is a family of frameworks which can be used to rapidly create loosely coupled Java applications

It is an inversion control container that provides flexible infrustructure to create Java applications

Its main Inversion of control is called dependency injection

Spring enables developers to build Java applications using POJO's and applying enterprise services to those POJO's as needed. This allows developers to focus business logic, while Spring manages infrustructure needs

The modules you need to know about from Spring are"

- Core
- Web
- ORM
- MVC
- AOP
- Security

# Spring Core

Core contains the most basic framework for IOC Container and dependency injection. This includes:
 
- Core and Beans: provides the fundamental framework for springs IOC container, including dependency injection features
    - Beans feature the BeanFactory which is an implementation of the factory pattern, to create beans used in dependency injection
- Context: provides the ApplicationContext which represents the Spring IOC container and is used to instantiate, configure, and assemble beans

Beans are the classes that we want Spring to manage for us

# Spring IOC Container and Dependency Injection

Inversion of Control is a design pattern in which control over certain parts of object-oriented design is inverted to achieve loose coupling

The IOC container is responsible for instantiating, configuring, and assembling our beans

It gathing information from an XML file called beans.xml

There are two types of IOC containers in Spring

- BeanFactory: the bog standard simple factory
- ApplicationContext: extended version of BeanFactory with more features
    - integration with Spring AOP
    - event propagation
    - message resource handling
    - application layer specific context

Dependency Injection removes dependencies from a program by providing the configuration in an external file

This loosely couples your code, making it easier to test, and implement in a wider variety of environments

Two official ways to achieve this dependency injection
- Constructor injection: the dependencies of the class are injected into the constructor
    - Generally known as more secure, enables implementation of immutable objects
- Setter injection: the dependencies of the calss are injected through a setter after the no-args constructor is called
    - Allows for partial dependencies, more flexible than constructor, can be used to resolve circular dependencies

# Bean Lifecycle

Beans are managed by the BeanFactory or the ApplicationContext, and have lifecycle, this is a high level overview:

1. Beans are first instantiated
2. Their properties are set
3. Any associated interfaces or objects are made aware of their existance
4. The bean is made aware of any associated interfaces as well
5. Any other methods, particulary custom created methods are invoked
6. The bean is ready for use
7. Once the bean is no longer used, it is marked for removal and a destroy method is invoked for the bean
8. Custom destory methods might be invoked
9. Bean is destoryed

# Scopes of beans

In the case of beans, scope can be seen as a sub-section of a larger application, with certain defined values, properties, and objects

There are six scopes that you could apply to a bean:

Singleton: default, there is a single instance of the bean per IOC Container

Prototype: a single bean definition is scoped to a number object instances

Request: a single bean definition is scoped to the lifecylce of a HTTP request

Session: a single bean definition is scoped to a HTTP session

Global Session: a single bean definition is scoped to a global HTTP session

Application: a single bean definition is scoped to a ServletContext

# XML vs Annotation Based Configuration

Our IOC Containers need someway of knowing how to inject dependencies for us

We have two ways to achieve this

- XML files
- Annotation and Java classes

# Annotations

-   `@Autowired` - Spring Annotation used to inject bean dependencies as needed, based on bean type.
-   `@Bean` - Spring annotation which plays the same role as the <bean/> element in an XML-based configuration, and you can specify an identifier for these beans with the use of the id (or name) property.
-   `@Component` - Generic used to declare an object as a bean.
-   `@ComponentScan` - Spring Annotation which specifies path locations for defined beans to be used for potential injection.
-   `@Configuration` - Spring annotation indicates a class file used to manage bean configurations using Java configuration similar to the Application Context file for an XML or annotation based configuration.
-   `@Inject` - Standard Java annotation used to inject bean dependencies as needed. Equivalent to Spring's `@Autowired` annotation.
-   `@Named` - Standard Java annotation for disambiguating beans based on bean name. Equivalent to Spring's `@Qualifier` annotation. Additionally can be used as an equivalent to Spring's `@Component` annotation to define beans as well.
-   `@Qualifier` - Spring Annotation which can be used in conjunction with `@Autowired` to disambiguate multiple beans of a defined type.
-   `@Required` - Standard Java annotation which indicates that an affected bean property must be populated at configuration time through an explicit property value in the bean's definition.
-   `@Resource` - Standard Java Annotation used to inject bean dependencies based on bean name, rather than type.

# Stereotypes

Stereotypes are a number of built in annotations which are used as markers to declare objects as beans, define their names and clarify to a developer what it will be used for

@Component: is the most generic stereotype used to declare an object as a bean

@Repository: is used to mark a class as being used to store data, or access data

@Service: is used to mark a class as being used as a service

@Controller: is used to mark a class as a Spring MVC Controller, which allows the user of handler mapping annotations

# Spring ORM

Spring ORM is springs Object Relation Mapping framework

Spring ORM supports Hibernate, Java Data Objects (JDO), Java Persistence (JPA), and more

We use Spring ORM to handle hibernate for us

You configure Spring ORM in the same beans.xml file that you configure your beans in

Benefits of Spring ORM:

- Easier to test
- Data Acess Exceptions Wrapping
- Resource Management
- Intergated Transaction Management