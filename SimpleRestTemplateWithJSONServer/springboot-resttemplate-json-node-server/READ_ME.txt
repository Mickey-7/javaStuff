reference: https://zetcode.com/springboot/resttemplate/

notice below result

22-08-2021 09:37:55 [main] INFO  org.springframework.boot.web.embedded.tomcat.TomcatWebServer.start - Tomcat started on port(s): 8080 (http) with context path ''
22-08-2021 09:37:55 [main] INFO  com.example.springbootresttemplatejsonnodeserver.SpringbootResttemplateJsonNodeServerApplication.logStarted - Started SpringbootResttemplateJsonNodeServerApplication in 2.027 seconds (JVM running for 2.431)
22-08-2021 09:37:55 [main] INFO  com.example.springbootresttemplatejsonnodeserver.MyRunner.lambda$run$0 - User{id=1, firstName='null', lastName='null', email='Tre80@gmail.com'}
22-08-2021 09:37:55 [main] INFO  com.example.springbootresttemplatejsonnodeserver.MyRunner.lambda$run$0 - User{id=2, firstName='null', lastName='null', email='Cameron8@gmail.com'}
22-08-2021 09:37:55 [main] INFO  com.example.springbootresttemplatejsonnodeserver.MyRunner.lambda$run$0 - User{id=3, firstName='null', lastName='null', email='Abe54@yahoo.com'}
22-08-2021 09:37:55 [main] INFO  com.example.springbootresttemplatejsonnodeserver.MyRunner.lambda$run$0 - User{id=4, firstName='null', lastName='null', email='Rylee82@hotmail.com'}
22-08-2021 09:37:55 [main] INFO  com.example.springbootresttemplatejsonnodeserver.MyRunner.lambda$run$0 - User{id=5, firstName='null', lastName='null', email='Mathilde21@yahoo.com'}
22-08-2021 09:37:55 [main] INFO  com.example.springbootresttemplatejsonnodeserver.MyRunner.lambda$run$0 - User{id=6, firstName='null', lastName='null', email='Rachel_Deckow@yahoo.com'}
22-08-2021 09:37:55 [main] INFO  com.example.springbootresttemplatejsonnodeserver.MyRunner.lambda$run$0 - User{id=7, firstName='null', lastName='null', email='Vernie.Lemke71@yahoo.com'}
22-08-2021 09:37:55 [main] INFO  com.example.springbootresttemplatejsonnodeserver.MyRunner.lambda$run$0 - User{id=8, firstName='null', lastName='null', email='Nolan51@hotmail.com'}
22-08-2021 09:37:55 [main] INFO  com.example.springbootresttemplatejsonnodeserver.MyRunner.lambda$run$0 - User{id=9, firstName='null', lastName='null', email='Earl.Bruen26@hotmail.com'}
22-08-2021 09:37:55 [main] INFO  com.example.springbootresttemplatejsonnodeserver.MyRunner.lambda$run$0 - User{id=10, firstName='null', lastName='null', email='Rusty.McDermott@yahoo.com'}


firstName and lastName are null

solution

use @JsonProperty("field_name_on_data.json") on the setter method

    @JsonProperty("first_name")
    public void setFirstName(String firstName) {

        this.firstName = firstName;
    }

    @JsonProperty("last_name")
    public void setLastName(String lastName) {

        this.lastName = lastName;
    }