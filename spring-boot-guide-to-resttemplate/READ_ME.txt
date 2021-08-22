reference:

https://stackabuse.com/spring-boot-guide-to-resttemplate/


go to https://crudcrud.com/

    find the button with : Click to create a unicorn
    then click the : the address of the REST endpoint
    that will open a link with the created unicorns

        https://crudcrud.com/api/75711794909c429595000490fbe7303a/unicorns

open postman then test

    GET Unicorn

        http://localhost:8080/unicornsByEntity/6121d12bdc46c203e8b3bfe1

    the id is from the link above

    2021-08-22 12:53:45.878 DEBUG 16744 --- [nio-8080-exec-2] o.s.web.client.RestTemplate              : HTTP GET https://crudcrud.com/api/75711794909c429595000490fbe7303a/unicorns/6121d12bdc46c203e8b3bfe1
    2021-08-22 12:53:45.880 DEBUG 16744 --- [nio-8080-exec-2] o.s.web.client.RestTemplate              : Accept=[text/plain, application/json, application/*+json, */*]
    2021-08-22 12:53:47.031 DEBUG 16744 --- [nio-8080-exec-2] o.s.web.client.RestTemplate              : Response 200 OK
    2021-08-22 12:53:47.031 DEBUG 16744 --- [nio-8080-exec-2] o.s.web.client.RestTemplate              : Reading to [java.lang.String] as "application/json;charset=utf-8"


    GET Unicorns

        http://localhost:8080/unicornsByObject

    2021-08-22 12:54:16.688 DEBUG 16744 --- [nio-8080-exec-3] o.s.web.client.RestTemplate              : HTTP GET https://crudcrud.com/api/75711794909c429595000490fbe7303a/unicorns
    2021-08-22 12:54:16.692 DEBUG 16744 --- [nio-8080-exec-3] o.s.web.client.RestTemplate              : Accept=[application/json, application/*+json]
    2021-08-22 12:54:17.499 DEBUG 16744 --- [nio-8080-exec-3] o.s.web.client.RestTemplate              : Response 200 OK
    2021-08-22 12:54:17.499 DEBUG 16744 --- [nio-8080-exec-3] o.s.web.client.RestTemplate              : Reading to [com.example.springbootguidetoresttemplate.util.UnicornResponse[]]


    POST Unicorn

        http://localhost:8080/unicornsByEntity

        {
            "_id": "6121d9a2dc46c203e8b3bfe7",
            "name": "MagiCorns",
            "age": 7,
            "colour": "shiny white"
        }

    2021-08-22 12:59:13.047 DEBUG 9052 --- [nio-8080-exec-2] o.s.web.client.RestTemplate              : HTTP POST https://crudcrud.com/api/75711794909c429595000490fbe7303a/unicorns
    2021-08-22 12:59:13.049 DEBUG 9052 --- [nio-8080-exec-2] o.s.web.client.RestTemplate              : Accept=[application/json, application/*+json]
    2021-08-22 12:59:13.060 DEBUG 9052 --- [nio-8080-exec-2] o.s.web.client.RestTemplate              : Writing [UnicornDto(name=MagiCorns, age=7, colour=shiny white)] with org.springframework.http.converter.json.MappingJackson2HttpMessageConverter
    2021-08-22 12:59:14.221 DEBUG 9052 --- [nio-8080-exec-2] o.s.web.client.RestTemplate              : Response 201 CREATED
    2021-08-22 12:59:14.222 DEBUG 9052 --- [nio-8080-exec-2] o.s.web.client.RestTemplate              : Reading to [com.example.springbootguidetoresttemplate.util.UnicornResponse]

    POST Unicorn

        http://localhost:8080/unicornsByObject

        {
            "_id": "6121da90dc46c203e8b3bfe8",
            "name": "uniquecorn",
            "age": 27,
            "colour": "black"
        }

    2021-08-22 13:03:10.056 DEBUG 17800 --- [nio-8080-exec-2] o.s.web.client.RestTemplate              : HTTP POST https://crudcrud.com/api/75711794909c429595000490fbe7303a/unicorns
    2021-08-22 13:03:10.059 DEBUG 17800 --- [nio-8080-exec-2] o.s.web.client.RestTemplate              : Accept=[application/json, application/*+json]
    2021-08-22 13:03:10.069 DEBUG 17800 --- [nio-8080-exec-2] o.s.web.client.RestTemplate              : Writing [UnicornDto(name=uniquecorn, age=27, colour=black)] with org.springframework.http.converter.json.MappingJackson2HttpMessageConverter
    2021-08-22 13:03:12.262 DEBUG 17800 --- [nio-8080-exec-2] o.s.web.client.RestTemplate              : Response 201 CREATED
    2021-08-22 13:03:12.262 DEBUG 17800 --- [nio-8080-exec-2] o.s.web.client.RestTemplate              : Reading to [com.example.springbootguidetoresttemplate.util.UnicornResponse]

    DELETE Unicorn

        http://localhost:8080/unicorns/6121d12bdc46c203e8b3bfe1

    2021-08-22 13:07:13.448 DEBUG 13164 --- [nio-8080-exec-3] o.s.web.client.RestTemplate              : HTTP DELETE https://crudcrud.com/api/75711794909c429595000490fbe7303a/unicorns/6121d12bdc46c203e8b3bfe1
    2021-08-22 13:07:14.238 DEBUG 13164 --- [nio-8080-exec-3] o.s.web.client.RestTemplate              : Response 200 OK


    PUT Unicorn

        http://localhost:8080/unicorns/6121d262dc46c203e8b3bfe2


