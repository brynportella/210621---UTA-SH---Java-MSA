# API Gateway

An API Gateway sits between the client and a collection of services

It essentially routes the clients requests to the correct service

## It acts as a single entry point to the application

In our examples we will be using Spring Cloud Gateway, which is Springs implementation of the outdated Zuul from the Netflix stack

# Load Balancing

In microservice architecture multiple instances of each service may be deployed for availablity and scalability, this limits failure of a single instance

To manage all of these instances you use a load balancing mechanism to ensure that incoming requests are spread across all available services

A load balancer acts as the traffic cop sitting in front of our server and routing client requests across all servers capable of filling those requests

There are two kinds of load balancing:

- Server side, a serverside application that tracks all requests coming in and distributes them between instances of the required service
    - AWS ELastic Load Balancer
- Client side, information is make aware to the client about the options for which instance of the service to query. The client decides to go to the one available
    - Ribbon, part of the Netflix stack, is a client-side load balancer, built into Spring Cloud Gateway. This is what we are using under the hood

# Discovery Service and Netflix Eureka Server

Service Discovery is a method for different services to locate each other. The service registry is a key part of service discovery

Service Registry:
- Holds network locations of service instances
- Contains currently available instances of each service with conection details
- The services query the service registry to retrieve details about other services
- Checks to see if the services are still running

Examples of Service Registries are Netflix Eureka and Consul

- Provide a REST API for registering and querying service instances
- Services register themselves with a POST request
- Re-register every 30 seconds with a PUT request
- Remove services with a DELETE request
- Get a service with a GET request

# Consul Discovery Service

Consul is an open-source tool that provides service discovery, health checks, load balancing, a service graph, mutual TLS indentity enforcement, and configuration key-value store

Consul agent is the core process of Consul, it maintains membership information, registers services, runs checks, responds to queries, and more. It must run on every node that is part of a Consul Cluster.

- Consul addresses the new microservice architecture challenges with service discovery and allowing operators to deploy application into a [**zero-trust network**](https://www.cloudflare.com/learning/security/glossary/what-is-zero-trust/).

- Consul offers a [service catalog](https://en.wikipedia.org/wiki/Service_catalog), health checks, automatic load balancing, and geo-failover across multiple instances of the same service

- Consul service mesh uses **mutual TLS** (mTLS) and will automatically generate and distribute the TLS certificates for every service in the mesh. The certificates are used for:
    - service idenitity verification
    - service communication encryption

- Consul service mesh deploys **sidecar proxies** locally alongside each service instance, which tranparently handles inbound and outbound service connections, automatically verifying and encrypting TLS connections between services

- Helps us to secure service communication at the network level by enabling us to manage service-to-service communication permissions using [intentions](https://www.consul.io/docs/connect/intentions.html).
    - Intentions define service based access control for services in the Consul service mesh and are used to control which services are allowed and not allowed to establish connection

- In addition to securing our services, Consul service mesh can also intercept data about service-to-service communications and surface it to monitoring tools

You can easily get started with Consul by using the Spring COuld Consul project that easily integrates Consul into a Spring Project