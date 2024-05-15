# QPros-API Automation Assignment


This Repo. contains test scripts to execute tests for /user in petstore3 https://petstore3.swagger.io/#/user/updateUser 

* use the following command to checkout "git checkout main"
* To Run the solution: open the root path of the project then try this "mvn clean package"

#Description:
Script will open the web portal, and scroll down to find a book. you can set the book name inside the main test class "AddBookTest".
the script will find the book, click on add to basket
then the script will be redirected to the cart page, check the book details on the cart page
then the script will be redirected to the checkout and validate that the billing details form appears.

#Features:
1. The solution is developed in JAVA and Rest assured.
2. solution includes CRUD operation for User Path
2. Allow data provider as Test data
3. Reports are generated per each test case.
5. The solution is following -> Page object model design pattern with simple SOLID principles to be adaptable to changes and provide usability.
6. The solution is running from testng.xml file.
7. Solution is dockerized (with some exceptions).

#Setup
1. make sure that Maven is downloaded and installed
2. make sure to project JAVA SDK from project settings = 20
3. From root path of the checkout main branch, type "mvn clean package"
4. Check the reports in reports directory inside the solution   
