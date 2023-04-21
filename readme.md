# DTO, mapper to DTO, and CRUD operations on H2 database  

**Sources**  
- modelmapper : https://www.baeldung.com/java-modelmapper  
- modelmapper reference :https://modelmapper.org/user-manual/property-mapping/  
- jpa named queries : https://www.baeldung.com/spring-data-derived-queries  

**Tips and tricks**  
- use @Builder Lombock annotation if you want to generate builders
- use <artifactId>modelmapper</artifactId> to map object between dto and other classes, without builders needed
- don't write builders by hand, it s tidious ... 

**Connect to H2 database using browser**  
http://localhost:8080/h2  
user/pass : sa/sa  

**CURL**  
curl -v -X POST -H "[content type]" -d "[post data]" [options] [URL]  
- -X: the parameter specifies which HTTP request method will be used when communicating with the server
- -H: the content-type header indicates the data type in the request body
- -d: the parameter specifies the data to be sent to the server in the POST message body
- -v: stand for "verbose"

**CURL GET**  
```
curl -v -X GET --location 'localhost:8080/etudiant/nomprenom?id=1' --header 'Content-Type: application/json' --data '{ "nothing":"empty"}'
```

**CURL POST to create a row**  
```
curl -v -X POST --location --request POST 'localhost:8080/etudiant/createEtudiant?nom=nmz&prenom=pmz&dateNaissance=31-07-2001&telephone=0607080910' --header 'Content-Type: application/json'
```

**CURL POST to update a row**  
```
curl -v -X POST --location 'localhost:8080/etudiant/updatebyid?id=1&nom=ker&prenom=stephane' --header 'Content-Type: application/json' --data '{ "nothing":"empty"}'
```




