# Circuit Breaker Design

Circuit breaking is used to prevent a network or service failure from cascading to other services

A circuit breaker wraps a function call with a monitor where the monitor will be tracking potential failures.

If a service is in the failed stage, the circuit will send the error message without making a call. If the service is up, then the breaker forwards the call to the needed service

Circuit Breakers have three states:

1. Closed state: when the service is up and running, the circuite remains in the closed state and all calls pass through to the service
2. Open state: when the number failures exceeds a predetermined threshold the breaker trips, then goes into the open state. The open state of the circuit breaker returns an error for all calls to the service without making the calls to the supplier microservice
3. Half-open state: The circuit breaker makes a trial call to the failed service periodically to check if it has recovered. If the call to the service times out, the circuit breaker remains open. If the call return successfully it switches to closed

Netflix's Hystrix library gives an implementation of a circuit breaker ( we will be using the default built in circuit breaker with Spring Cloud)

# Messaging Queues

A message queue is a software component used for passing data between services. It exposes an interface for adding, reading, and removing messages

They facilitate asynchronous communication between services

Messaging queues are producers consumers

There are two messaging models:

Point-to-point: the producer is called the sender, the consumer is called the receiver
- Senders and receievers exhange messages through a queue
- Each message is received by only one receiver
- Messages are ordered

Pub/Sub: allows a message producer to broadcast a message to one or consumers
- The producers are called publishers, and they publish messages to a topic
- The consumers are called subscribers, and they can subscribe to topics and conumes the messages

Examples of message are RabbitMQ, Amazon SQS, Apache Kafka

# Config Server

We cannot simply store configuration details in our code, we need a way to have our configurations be flexible enough to cope with multiple applications, environments, and service instances

Spring Cloud Config allows us to do that by keeping configurations on Version Control Software like Git

Instead of having a local configuration, Spring Cloud Config lets you store all of your configuration in one repository, and pull the files whenever configuration is needed, for any service, or environment

# Containerization

A container is a standard unit of softwar that packages up an application and all its dependencies so the application runs quickly and relibly from one computing environment to another

Containerization is the process of packaging an appliation, along with its required libraries, frameworks, and configuration files together so that it can be run in various computing environments.

For this we could use Docker

Container Orchestration automates the deployment, management, scaling, and networking on containers

Tools for orchestration include: Kubernetes, Docker Swarm, Apache Mesos

# Distributed Tracing

Distributed tracing tells the story of an end-to-end request, including everything from mobile performance to database health

It gives a solution for describing and analyzing cross-platform transactions, which can perform anomaly detection, diagnosing steady state problems, distributed profiling, resource attribution, and workload modeling

A trace starts when a user sends a request

A span is a record of time spent in different services, these are given unique ids

All spans of a request get combined into a single distributed trace, where we can view what all hapened during the request

Some distributed tracing tools:
- Zipkin, Jaeger, Prometheus, OpenTelemetry
- Spring Cloud Slueth, which provics Spring Boot auto configuration

# Monitoring Tools

Monitoring is the process of reporting, gathering, and storing data. Monitoring microservices helps the organization to:

- Understand the overall health of the application
- Gain insight into the performance of each individual service that makes up the application
- Ensure the API transactions are available and performing well
- Isolate problematic transactions and endpoints
- Optimize the end user experience

Some monitoring tools:
- Zipkin
- Grafana
- Prometheus
- CAdvisor
- Sensu
- Nagios