FROM tomcat:9.0

RUN rm -rf /usr/local/tomcat/webapps/*

COPY frontend /usr/local/tomcat/webapps/LMS

EXPOSE 8080

CMD ["catalina.sh", "run"]
