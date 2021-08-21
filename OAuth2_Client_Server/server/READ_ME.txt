reference:https://www.javainuse.com/spring/spring-boot-oauth-authorization-code
          https://www.javainuse.com/spring/spring-boot-oauth-access-token
--------------------------------------------------------------------------------------------------------------------------

error encountered:

org.springframework.beans.factory.BeanCreationException: Error creating bean with name 'springSecurityFilterChain' defined in class path resource [org/springframework/security/config/annotation/web/configuration/WebSecurityConfiguration.class]: Bean instantiation via factory method failed; nested exception is org.springframework.beans.BeanInstantiationException: Failed to instantiate [javax.servlet.Filter]: Factory method 'springSecurityFilterChain' threw exception; nested exception is java.lang.NoClassDefFoundError: javax/xml/bind/JAXBException
	at org.springframework.beans.factory.support.ConstructorResolver.instantiate(ConstructorResolver.java:658) ~[spring-beans-5.3.9.jar:5.3.9]
	at org.springframework.beans.factory.support.ConstructorResolver.instantiateUsingFactoryMethod(ConstructorResolver.java:486) ~[spring-beans-5.3.9.jar:5.3.9]
	at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.instantiateUsingFactoryMethod(AbstractAutowireCapableBeanFactory.java:1334) ~[spring-beans-5.3.9.jar:5.3.9]
	at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.createBeanInstance(AbstractAutowireCapableBeanFactory.java:1177) ~[spring-beans-5.3.9.jar:5.3.9]



solution:

https://stackoverflow.com/questions/47866963/oauth2-spring-error-creating-bean-with-name-springsecurityfilterchain

add the following dependencies:

		<dependency>
			<groupId>javax.xml.bind</groupId>
			<artifactId>jaxb-api</artifactId>
			<version>2.3.0</version>
		</dependency>
		<dependency>
			<groupId>com.sun.xml.bind</groupId>
			<artifactId>jaxb-core</artifactId>
			<version>2.3.0</version>
		</dependency>
		<dependency>
			<groupId>com.sun.xml.bind</groupId>
			<artifactId>jaxb-impl</artifactId>
			<version>2.3.0</version>
		</dependency>
		<dependency>
			<groupId>javax.activation</groupId>
			<artifactId>activation</artifactId>
			<version>1.1.1</version>
		</dependency>



--------------------------------------------------------------------------------------------------------------------------

error encountered:


java.lang.IllegalArgumentException: There is no PasswordEncoder mapped for the id "null"
	at org.springframework.security.crypto.password.DelegatingPasswordEncoder$UnmappedIdPasswordEncoder.matches(DelegatingPasswordEncoder.java:254) ~[spring-security-crypto-5.5.2.jar:5.5.2]
	at org.springframework.security.crypto.password.DelegatingPasswordEncoder.matches(DelegatingPasswordEncoder.java:202) ~[spring-security-crypto-5.5.2.jar:5.5.2]
	at org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter$LazyPasswordEncoder.matches(WebSecurityConfigurerAdapter.java:595) ~[spring-security-config-5.5.2.jar:5.5.2]


solution:

add {noop} on password

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .inMemoryAuthentication()
                .withUser("admin")
                .password("{noop}admin")
                .authorities("ROLE_ADMIN");
    }

--------------------------------------------------------------------------------------------------------------------------


error encountered:

2021-08-21 08:34:04.206  INFO 15464 --- [nio-8080-exec-4] o.s.s.o.p.e.AuthorizationEndpoint        : Handling OAuth2 error: error="invalid_request", error_description="At least one redirect_uri must be registered with the client."


solution:

https://stackoverflow.com/questions/59844841/spring-boot-oauth2-0-at-least-one-redirect-uri-must-be-registered-with-the-cl

After authentication, you may need to contact the resource owner and ask for support and then redirect to your client application or you may redirect to client application directly. for that, add redirectUris in your Authorization server config

@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter{

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients.inMemory().withClient("client_id").secret("client_secret").authorizedGrantTypes("authorization_code")
            .scopes("read").authorities("CLIENT")

            .redirectUris("http://localhost:8090/your_redirect_URL");
    }
}

--------------------------------------------------------------------------------------------------------------------------

