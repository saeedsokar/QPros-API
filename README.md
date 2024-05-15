# QPros-API Automation Assignment


This Repo. contains test scripts to execute tests for /user in petstore3 https://petstore3.swagger.io/#/user/updateUser 

* use the following command to checkout "git checkout main"
* To Run the solution: open the root path of the project then try this "mvn clean package"

#Description:
Script will execute CRUD operations for the /user path endpoints and assert the values from data provider

#Features:
1. The solution is developed in JAVA and Rest assured.
2. solution includes CRUD operation for User Path
2. Allow data provider as Test data using excel sheets
3. Reports are generated per each test case.
5. The solution is following -> Page object model design pattern with simple SOLID principles to be adaptable to changes and provide usability.
6. The solution is running from testng.xml file.
7. Solution is dockerized (with some exceptions).

#Setup
1. make sure that Maven is downloaded and installed
2. make sure to project JAVA SDK from project settings = 20
3. From root path of the checkout main branch, type "mvn clean package"
4. Check the reports in reports directory inside the solution   
