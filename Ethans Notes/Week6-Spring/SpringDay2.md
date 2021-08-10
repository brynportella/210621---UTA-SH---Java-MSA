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