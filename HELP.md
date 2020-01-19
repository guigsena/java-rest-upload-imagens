#What was Build
I created a Spring Boot rest application that accepts file uploads. 

#Run the Application
For run the application you need to execute the class UploadFilesApplication or generetaded the jar and run it.

#Documetation
The documentation is available on http://localhost:8080/api/file-upload/swagger-ui.html

##API Guides

###GET
http://localhost:8080/api/file-upload/file
param: "name" (optional)

###POST
http://localhost:8080/api/file-upload/file
param: "file"
param: "idUser

###DELETE
http://localhost:8080/api/file-upload/file/{id}
