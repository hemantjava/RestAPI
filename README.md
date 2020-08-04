# RestAPI

Swagger Home Page
===================================
http://localhost:8384/swagger-ui.html 

#Driver details
spring.datasource.url=jdbc:h2:mem:testdb
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=
 
# Custom H2 Console URL
http://localhost:8384/h2-console

#Active profile is:-
spring.profiles.active=h2

# Actuator see health of application 
http://localhost:8384/actuator
http://localhost:8384/actuator/mappings


Oracle JDBC Driver compatible with JDK6, JDK7, and JDK8

<dependency>
  <groupId>com.oracle.database.jdbc</groupId>
  <artifactId>ojdbc6</artifactId>
  <version>11.2.0.4</version>
</dependency>
Oracle JDBC Driver compatible with JDK8, JDK9, and JDK11

<dependency>
  <groupId>com.oracle.database.jdbc</groupId>
  <artifactId>ojdbc8</artifactId>
  <version>19.3.0.0</version>
</dependency>
Oracle JDBC Driver compatible with JDK10 and JDK11

<dependency>
  <groupId>com.oracle.database.jdbc</groupId>
  <artifactId>ojdbc10</artifactId>
  <version>19.3.0.0</version>
</dependency>