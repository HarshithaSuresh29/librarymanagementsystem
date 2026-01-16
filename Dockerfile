FROM tomcat:9.0

RUN rm -rf /usr/local/tomcat/webapps/*

COPY frontend /usr/local/tomcat/webapps/LMS
COPY frontend/WEB-INF/lib/*.jar /usr/local/tomcat/lib/

EXPOSE 8080

CMD ["catalina.sh", "run"]
