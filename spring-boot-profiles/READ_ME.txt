reference

https://www.concretepage.com/spring-boot/spring-boot-profiles-example#create-profiles
https://www.baeldung.com/embeddedservletcontainercustomizer-configurableembeddedservletcontainer-spring-boot

for dev : http://localhost:8282/spring-boot-dev

for prod : http://localhost:8080

Then application-dev.properties as well as application.properties will be used by our spring boot application.
If we add active profile prod as follows

spring.profiles.active=prod