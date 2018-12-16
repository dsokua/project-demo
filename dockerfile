FROM java:8
WORKDIR /
COPY /target/cignademo-0.0.1-SNAPSHOT.war app.war
CMD ["java","-jar","/app.war"]
