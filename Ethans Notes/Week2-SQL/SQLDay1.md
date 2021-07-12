# Amazon Web Services (AWS)

Cloud computing services that are provided by Amazon

Cloud computing service provides a simple way to access servers, storage, databases, and a broad set of application servers across the internet

There are a few key advantages to cloud computing:

-   Pay as you go, you only pay for what you need
-   Lower as as you go prices due to economics of scale
-   Automically scales up or down
-   Easily and quickly allocate resources
-   No need to buy expensive server equipment to host products
-   Deploy your application globally in seconds

With AWS you only pay for the services that you are currently using, there are also free tiers for people to test amazons services

AWS also has 24 regions of availablilty, with 77 zones

An AWS region is a geographic location with a collection of availbility zones

An availability zone is a physical data center inside of that region

# AWS EC2 (Elastic Compute Cloud)

AWS EC2 is a service that provides secure reliable resizable compute capacity in the cloud. It is designed to make a web-scaled cloud computing easier for developers

An Amazon EC2 provides:

-   A virtual computing environment, (you can host Java appliations)
-   Preconfigured environment templates called AMI (Amazon Machine Images)
    -   These contain a virtual image of a server that contains the OS, and all the softwares you might need for hosting an application
-   You can configure these to you liking
-   It has secure login, and firewalls

The filewalls are known as security groups:

-   These are setup at the instance level, it holds a series of white listed ip's we are explicitly allowing

Elastic Block Storage (EBS): provides block level storage volumes for use with EC2 instances

-   If you need extra storage on your EC2, you can attack a EBS Volume

# AWS RDS (Relational Database Service)

AWS RDS is a service that makes it easier to setup, operate, and scale a relational database in the AWS Cloud. It provides cost-effiecent, resizable capacity for industry standard relational databases, and manages common database admin tasks

AWS will completely setup, and manage your database instance for you

RDS allows you to choose from many SQL based database management softwares

# ASW S3 (Simple Storage Service)

AWS S3 is an object storage service that offers industry-leading scalability, data availablity, security, and performance

Allows you to store and retrieve almost any amount of data from anywhere

S3 uses what is called object storage, where each object is stored in its own bucket

-   You can access these buckets via a dedicated URL given by Amazon
-   You can use these buckets to backup files, host static websites, host media, host applications
-   You can accces, and add items to the bucket with API's, which are very useful
