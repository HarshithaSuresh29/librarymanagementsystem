FROM tomcat:9.0

# Remove default apps
RUN rm -rf /usr/local/tomcat/webapps/*

# Copy your project to Tomcat
COPY frontend /usr/local/tomcat/webapps/LMS

EXPOSE 8080

CMD ["catalina.sh", "run"]
