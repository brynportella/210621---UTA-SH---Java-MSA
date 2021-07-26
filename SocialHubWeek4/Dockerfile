FROM tomcat:8-jre8-alpine

RUN rm -rf /usr/local/tomat/webapps/*

COPY target/SocialHubWeek3-0.0.1-SNAPSHOT.war /usr/local/tomcat/webapps/SocialHubWeek3-0.0.1-SNAPSHOT.war

CMD ["catalina.sh", "run"]
