reference:https://www.javainuse.com/spring/spring-boot-oauth-authorization-code
          https://www.javainuse.com/spring/spring-boot-oauth-access-token

reference:

https://arturk9.wordpress.com/2017/02/22/springboot-how-to-enable-jsp-in-intellij/

dependencies needed to make jsp work

<dependency>
   <groupId>org.apache.tomcat.embed</groupId>
   <artifactId>tomcat-embed-jasper</artifactId>
</dependency>

<dependency>
   <groupId>javax.servlet</groupId>
   <artifactId>jstl</artifactId>
</dependency>

also create directory under main

main
    java
    resources
    webapp
        WEB-INF
            jsp
                file_name.jsp


the file_name.jsp corresponds to the API endpoints or url on controller


and on application.properties, add below:

spring.mvc.view.prefix:/WEB-INF/jsp/
spring.mvc.view.suffix:.jsp

