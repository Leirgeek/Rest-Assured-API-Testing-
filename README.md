# Rest-Assured-API-Testing-
Testing API using Rest Assured 
Overview
This project is aimed at automating the testing process of the ReqRes API using Rest Assured framework. The project employs the Page Object Model to enhance test maintainability and readability. Through this project, I've gained proficiency in API testing, Rest Assured, and implementing design patterns like Page Object Model.

Configuration
In the ConfigurationPage class, the base URL for the API is configured:

public static final String BASE_URL = "https://reqres.in/";
Test Pages
1. userTests
This class contains tests related to user operations.

a. selectAllMembers()
This method illustrates the GET method to retrieve all members.

b. singleUserNotFound()
This method tests the scenario where a single user is not found.

c. testPost()
This method demonstrates the POST method.

2. RegistrationTests
This class contains tests related to user registration operations.

a. registerUserSuccessful()
This test method illustrates the successful registration of a user using the POST method.

b. registerUserNotSuccessful()
This test method covers scenarios where user registration is not successful.

c. updateUserSuccessful()
This test method demonstrates the successful update of user information using the UPDATE method.

d. deleteUser()
This test method illustrates the DELETE method to delete a user.

Test Output
Test outputs can be found in the test-output folder.

Conclusion
This project has enabled me to gain practical experience in automating API testing using Rest Assured and implementing design patterns like Page Object Model for better test organization and maintenance. Through writing these tests, I've strengthened my understanding of HTTP methods like GET, POST, UPDATE, and DELETE
