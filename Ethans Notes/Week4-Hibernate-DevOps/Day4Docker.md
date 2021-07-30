# SonarCloud/SonarLint

SonarCloud and SonarLint are code quality analysis tools which increase readability, security, and maintainability of your code

These tools can help produce higher quality code, and provide standardization between developers

Code quality analysis tools are programs specifically designed to expose errors and code smells

Code smell: characteristic of the code, that while not actually preventing propper functionality, may prevent maintainability of your code

Vulnerabilities: data security issues

Maintainability issues:
- Confusing or hard to maintain code
- Repeated instances of code
- Unused imports
- Empty code blocks
- Unaddressed automated code comments

Sonar Cloud is a cloud based review solution which can be configure to review code within a cloud repository, such as Github

How to setup Sonar Cloud: https://sonarcloud.io/documentation/getting-started/github/

Sonar Lint is a free, open source linting tool, which you can intall directly into your ide

Traditional IDE's use some sort of linter, but Sonar Lint provides further linting as listed above

To install on Eclipse/STS, you can simply go to the marketplace, search for Sonar Lint and install

# Docker

# Containers vs VM's (Virtual Machines)

Containers and Virtual Machines both provide the ability to isolate processes, however each has their own pros and cons

Virtual Machines: simulate a physical server/machine

- They virtualize an entire OS
- Enabled by hypervisors, a software that coordinates between VM's and interfaces with the underyling infrastructure/machine

VM pros:

- near total isolation
- provides virtualization
- ensures an application runs reliably regardless of the host/mahine

VM Cons:

- considerably bulky, expensive in the context of resources

Containers bndle together applications with their supporting libraries and dependencies allowing then to run in isolation

- The container will share the underlying OS kernel
- Much lighter weight than a VM
- Containerization is provided by an engine running on the host, ie Docker

Container Pros:

- considered light weight, because they dont't require spinning up an entire OS
- they can enable layers of isolation
- provide a virtualized view of certain resources
- package an application in an isolated enviornment
- ensures an application can run reliably regardless of the host

Container Cons:

- having layers of isolation

In general, it is suggested to use containers over VM's, because of the cost of resources

# Containerization

Containerization helps to ensure the application, or set of processes can run reliably regardless of the host environment. The container shouldn't be able to modify or interact with anything it doesn't need to, and on the whole, changes in the container should not effect the host, or other containers.

Linux containers are the foundation of most modern container systems
- began with cgroups and namespaces
    - cgroups allowed control over the resources
    - namesspaces allowed for encapsulation of resources, and determined what is visible to particular resources

These contrainer are:

- built from images (a template for a container)
- run on an engine (on the host OS), Docker Engine
- Are idealy stateless
    - Any state that is needed for an application should be stored in a way that is detached from the actual container
- Virtualized and isolated

More benefits of Containers:
- Secure
- Standardized and Portable
- Light weight
- Flexible and loosely coupled
- Scalable

# Docker Architecture

![docker-arch](docker.svg)

Docker runs on a Client-Server Architecture
- You run commands on the Client, which interacts with the Docker Daemon

## Docker CLI

The Docker Command Line Interface is the client in the client-server architecture
- It is used to interact with the Daemon
- Uses a Rest API to send commands to the Docker Daemon

## Docker Daemon

The Docker Daemon is the long running process on the docker host that does all the heavy lifting

- manages Docker Objects
- containers
- images
- It is the core of the running dockerized applications

## Docker Registries

Provides a centralized place to store images, allows you to easily share imgaes between docker hosts

- Dockerhub is a public registry mananged by Docker that allows you to push and pull containers

## Docker Objects

Are the building blocks that are managed by the docker daemone. The most fundamental objects are images and containers

# Docker Images

Docker images are a blueprint for a container
- Outlined by a dockerfile

# Docker Containers

Docker Containers are a runnable isolated instance of a set of processes and dependencies

- these are built from docker images, which lay out everything the proccess that run in the container will need
- managed by the docker daemon as part of the docker engine

# Dockerfile

Defines everything needed for an image. It outlines the starting point, dependencies and commands that make up all the processes needed for an image and in turn a container
- Use these to create our images, contain a step-by-step instructions to create the image

# Docker Volumes

Allow you to store/persist data for a container

# Docker Best Practices

The goals of containerization are:

- ephermal containers: the containers should be as easy as possible to tear down and build up, requiring minimal configuration
- lightweight containers and images

Be mindful of build context, aka what directory you are building in

Try to leverage multi-stage builds and image cache

Each container should serve only one purpose

Make commands in your dockerfile readible by separating them onto different lines

Use volumes to persist data

User secrets for sensitive data and config files for configurations are that are not sensitive

# Dockerfile keywords

`FROM image name`

- Specifies the parent image from which the new image should be based

`RUN <commands>` / `RUN ["executable", "param1", "param2"...]`
- used to setup your image, that state of the image after each run command that is commited forms a new layer

`ADD <src> <destination>`

- adds files from build context or url to an imgae

`COPY <src> <destination>`
- adds files from the build context to the image, this is now prefered over ADD

`EXPOSE`
- outlines the ports that are being listened on by processes in the container

`VOLUMN ["/dirname"]`
- creates a mount point in the image, and thus container with a particular name

`WORKDIR`
- sets the working directory in the image and the eventual container of commands that follow

`CMD`
- used to execute/run processes needed inside of your container

# Building an Image

There are two ways to create an image:

- Using the `docker build anyflags PATH` command in the CLI
    - This is how you can create an image with a dockerfile
- Using the `docker commit flags CONTAINER imagename` command in the CLI
    - You are committing the changes from the container specified to the image specified
    - You are created an image based off of an existing container

# Creating a Container

There are two ways to create a Docker Container

- Using `docker create imagename` in the CLI
    - this creates a container in its 'created' state, and configures and sets it up to be run including the writaible layer on the image from which the container is created
    - You will manually have to start this container
- Using `docker run flags imagename` in the CLI
    - This will pull the image from the registry if it does not exist locally
    - Creates, and runs the container automatically

# Managing Containers

Some useful commads to manage containers include:

-   `docker container ls` displays all running containers
-   `docker ps -a` displays all containers
-   `docker container kill containerid` can be used to stop a container from running
-   `docker container pause containerid` can be used to pause all the processes in a container
-   `docker container start containerid` will start up a consiner that was paused/not running
-   `docker container rm flags containerid` will remove a container
-   `docker volume rm volumename` will remove a volume

There are more commands in this cheatsheet: https://www.docker.com/sites/default/files/d8/2019-09/docker-cheat-sheet.pdf

# Docker Compose

Docker Compose is a tool that makes creating and managain multi-container application easier