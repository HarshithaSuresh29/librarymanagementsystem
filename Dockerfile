FROM tomcat:9.0

# Remove default apps
RUN rm -rf /usr/local/tomcat/webapps/*

# Copy your web app
COPY frontend /usr/local/tomcat/webapps/LMS

# Copy MySQL driver
COPY frontend/WEB-INF/lib/*.jar /usr/local/tomcat/lib/

EXPOSE 8080

CMD ["catalina.sh", "run"]
